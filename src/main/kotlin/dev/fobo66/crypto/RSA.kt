package dev.fobo66.crypto

import java.math.BigInteger
import java.util.Random
import java.util.concurrent.ThreadLocalRandom

const val DEFAULT_KEY_LENGTH = 1024

class RSA(
    keyLength: Int = DEFAULT_KEY_LENGTH,
    random: Random = ThreadLocalRandom.current()
) {
    private val p: BigInteger = BigInteger.probablePrime(keyLength, random)
    private val q: BigInteger = BigInteger.probablePrime(keyLength, random)
    private val keyPowerN: BigInteger = p.multiply(q)
    private val phi: BigInteger = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))
    private val e: BigInteger = BigInteger.probablePrime(keyLength / 2, random)
    private val d: BigInteger

    init {
        while (phi.gcd(e) > BigInteger.ONE && e < phi) {
            e.add(BigInteger.ONE)
        }
        d = e.modInverse(phi)
    }

    fun encrypt(message: ByteArray?): ByteArray {
        return BigInteger(message).modPow(e, keyPowerN).toByteArray()
    }

    fun decrypt(message: ByteArray?): ByteArray {
        return BigInteger(message).modPow(d, keyPowerN).toByteArray()
    }
}
