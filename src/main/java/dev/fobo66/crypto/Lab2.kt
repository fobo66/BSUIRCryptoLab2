package dev.fobo66.crypto

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import java.io.IOException
import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val rsa = RSA()
    var message = "Hello World!"
    val parser = ArgParser("lab2")
    val inputFile by parser.option(ArgType.String, shortName = "f", fullName = "file", description = "Input file")
    try {
        parser.parse(args)
        if (inputFile != null) {
            val filePath = inputFile!!
            println("Reading cleartext from file $filePath...")
            message = loadClearTextFromFile(filePath)
        }
        val encryptedText = rsa.encrypt(message.toByteArray())
        val decryptedText = rsa.decrypt(encryptedText)
        printResults(message, encryptedText, decryptedText)
    } catch (e: IOException) {
        throw RuntimeException("Failed to read cleartext from file", e)
    }
}

private fun printResults(message: String, encryptedText: ByteArray, decryptedText: ByteArray) {
    println("Clear text: $message")
    println("Encrypted text: " + BigInteger(encryptedText).toString(16))
    println("Decrypted text: " + String(decryptedText))
}

@Throws(IOException::class)
private fun loadClearTextFromFile(filePath: String): String {
    return String(Files.readAllBytes(Paths.get(filePath)))
}
