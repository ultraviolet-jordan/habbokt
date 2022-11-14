package com.habbokt.web.common

import com.habbokt.web.exception.CipherException
import java.security.SecureRandom
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec

/**
 * @author Jordan Abraham
 */
private val key = KeyGenerator.getInstance("AES").also {
    it.init(128)
}.generateKey()

private val ivParameterSpec = IvParameterSpec(
    ByteArray(16).apply {
        SecureRandom().nextBytes(this)
    }
)

fun String.decrypt(): String = try {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec)
    String(cipher.doFinal(Base64.getDecoder().decode(this)))
} catch (exception: Exception) {
    throw CipherException
}

fun String.encrypt(): String = try {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec)
    Base64.getEncoder().encodeToString(cipher.doFinal(toByteArray()))
} catch (exception: Exception) {
    throw CipherException
}
