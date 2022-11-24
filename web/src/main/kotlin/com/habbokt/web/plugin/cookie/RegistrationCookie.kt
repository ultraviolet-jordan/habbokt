package com.habbokt.web.plugin.cookie

import com.habbokt.session.RegistrationSession
import com.habbokt.web.plugin.Authentications
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.SessionsConfig
import io.ktor.server.sessions.cookie

/**
 * @author Jordan Abraham
 */
fun SessionsConfig.installRegistrationCookie(
    encryptionKey: ByteArray,
    signKey: ByteArray
) {
    cookie<RegistrationSession>(Authentications.Registration) {
        cookie.path = "/"
        cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
        // uses the AES and HmacSHA256 algorithms
        transform(SessionTransportTransformerEncrypt(encryptionKey, signKey))
    }
}