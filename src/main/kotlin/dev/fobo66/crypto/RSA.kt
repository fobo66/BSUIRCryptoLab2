package dev.fobo66.crypto

import java.math.BigInteger
import java.util.concurrent.ThreadLocalRandom

class RSA {
    private val p: BigInteger
    private val q: BigInteger
    private val N: BigInteger
    private val phi: BigInteger
    private val e: BigInteger
    private val d: BigInteger
    private val bitlength = 1024
    private val random = ThreadLocalRandom.current()

    init {
        p = BigInteger.probablePrime(bitlength, random)
        q = BigInteger.probablePrime(bitlength, random)
        N = p.multiply(q)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
        e = BigInteger.probablePrime(bitlength / 2, random)
        while (phi.gcd(e) > BigInteger.ONE && e < phi) {
            e.add(BigInteger.ONE)
        }
        d = e.modInverse(phi)
    }

    fun encrypt(message: ByteArray?): ByteArray {
        return BigInteger(message).modPow(e, N).toByteArray()
    }

    fun decrypt(message: ByteArray?): ByteArray {
        return BigInteger(message).modPow(d, N).toByteArray()
    }
}
