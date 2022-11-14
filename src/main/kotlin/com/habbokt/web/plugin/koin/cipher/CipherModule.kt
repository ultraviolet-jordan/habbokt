package com.habbokt.web.plugin.koin.cipher

import com.habbokt.web.common.Cipher
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun cipherModule(secret: String) = module(createdAtStart = true) {
    single { Cipher(secret.toByteArray()) }
}
