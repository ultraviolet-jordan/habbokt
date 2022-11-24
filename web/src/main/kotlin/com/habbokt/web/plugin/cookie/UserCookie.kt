package com.habbokt.web.plugin.cookie

import com.habbokt.session.UserSession
import com.habbokt.web.plugin.Authentications
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.SessionsConfig
import io.ktor.server.sessions.cookie

/**
 * @author Jordan Abraham
 */
fun SessionsConfig.installUserCookie(
    encryptionKey: ByteArray,
    signKey: ByteArray
) {
    cookie<UserSession>(Authentications.User) {
        cookie.path = "/"
        cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
        // uses the AES and HmacSHA256 algorithms
        transform(SessionTransportTransformerEncrypt(encryptionKey, signKey))
    }
}