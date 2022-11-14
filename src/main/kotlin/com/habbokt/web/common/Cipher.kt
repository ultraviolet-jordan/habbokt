package com.habbokt.web.common

import java.security.SecureRandom
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * @author Jordan Abraham
 */
class Cipher(
    private val secret: ByteArray
) {
    fun decrypt(string: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(secret, "AES"), generateIv())
        val plainText = cipher.doFinal(Base64.getDecoder().decode(string))
        return String(plainText)
    }

    fun encrypt(string: String): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(secret, "AES"), generateIv())
        val cipherText = cipher.doFinal(string.toByteArray())
        return Base64.getEncoder().encodeToString(cipherText)
    }

    private fun generateIv(): IvParameterSpec = IvParameterSpec(
        ByteArray(16).apply {
            SecureRandom().nextBytes(this)
        }
    )
}
