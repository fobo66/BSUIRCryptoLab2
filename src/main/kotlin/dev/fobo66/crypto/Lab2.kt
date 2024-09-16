package dev.fobo66.crypto

import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import java.io.IOException
import java.math.BigInteger
import java.nio.file.Paths
import kotlin.io.path.readText

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
        throw IllegalStateException("Failed to read cleartext from file", e)
    }
}

private fun printResults(
    message: String,
    encryptedText: ByteArray,
    decryptedText: ByteArray,
) {
    println("Clear text: $message")
    println("Encrypted text: " + BigInteger(encryptedText).toString(HEX_RADIX))
    println("Decrypted text: " + decryptedText.toString(Charsets.UTF_8))
}

private const val HEX_RADIX = 16

@Throws(IOException::class)
private fun loadClearTextFromFile(filePath: String): String = Paths.get(filePath).readText()
