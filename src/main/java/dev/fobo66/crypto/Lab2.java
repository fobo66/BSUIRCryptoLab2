package dev.fobo66.crypto;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.math.BigInteger;
import java.nio.file.Paths;

public class Lab2 {
    public static void main(String[] args) {

        RSA rsa = new RSA();
        String message = "Hello World!";

        Options options = new Options();
        options.addOption("f", "file", true, "Input file");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("file")) {
                String filePath = cmd.getOptionValue("file");
                System.out.format("Reading cleartext from file %s...%n", filePath);
                message = loadClearTextFromFile(filePath);
            }

            byte[] encryptedText = rsa.encrypt(message.getBytes());
            byte[] decryptedText = rsa.decrypt(encryptedText);
            printResults(message, encryptedText, decryptedText);
        } catch (ParseException e) {
            System.err.println("Failed to parse command line arguments. Reason: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read cleartext from file", e);
        }
    }

    private static void printResults(String message, byte[] encryptedText, byte[] decryptedText) {
        System.out.println("Clear text: " + message);
        System.out.println("Encrypted text: " + new BigInteger(encryptedText).toString(16));
        System.out.println("Decrypted text: " + new String(decryptedText));
    }

    private static String loadClearTextFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
