package dev.fobo66.crypto

import kotlin.test.Test
import kotlin.test.assertEquals

class Lab2Test {
    @Test
    fun `RSA algorithm produces correct output`() {
        val rsa = RSA()
        val clearText = "test"
        val encryptedText = rsa.encrypt(clearText.toByteArray())
        val decryptedText = rsa.decrypt(encryptedText)
        assertEquals(clearText, decryptedText.toString(Charsets.UTF_8))
    }

    @Test
    fun `RSA with customized key length`() {
        val rsa = RSA(keyLength = 2048)
        val clearText = "test"
        val encryptedText = rsa.encrypt(clearText.toByteArray())
        val decryptedText = rsa.decrypt(encryptedText)
        assertEquals(clearText, decryptedText.toString(Charsets.UTF_8))
    }
}
