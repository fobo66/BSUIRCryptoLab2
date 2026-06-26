package dev.fobo66.crypto

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.transform.theme
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import java.io.IOException
import java.math.BigInteger
import kotlin.io.path.readText

private const val HEX_RADIX = 16

class Lab2 : CliktCommand() {
    val inputFile by option("-f", "--file")
        .path(mustBeReadable = true, canBeDir = false, mustExist = true)
        .help { theme.info("Input file") }

    val keyLength by option("-l", "--length")
        .int()
        .help { theme.info("Key length. Default is $DEFAULT_KEY_LENGTH") }
        .default(DEFAULT_KEY_LENGTH)

    override fun run() {
        var message = "Hello World!"

        try {
            inputFile?.let {
                echo("Reading cleartext from file ${it.fileName}...")
                message = it.readText()
            }
            val rsa = RSA(keyLength = keyLength)
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
        echo("Clear text: $message")
        echo("Encrypted text: ${BigInteger(encryptedText).toString(HEX_RADIX)}")
        echo("Decrypted text: ${decryptedText.toString(Charsets.UTF_8)}")
    }

}

fun main(args: Array<String>) = Lab2().main(args)
