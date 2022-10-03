package dev.fobo66.crypto

import java.math.BigInteger
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class RSA {
    private var p: BigInteger
    private var q: BigInteger
    private var N: BigInteger
    private var phi: BigInteger
    private var e: BigInteger
    private var d: BigInteger
    private val bitlength = 1024
    private val r: Random

    init {
        r = ThreadLocalRandom.current()
        p = BigInteger.probablePrime(bitlength, r)
        q = BigInteger.probablePrime(bitlength, r)
        N = p.multiply(q)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
        e = BigInteger.probablePrime(bitlength / 2, r)
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
