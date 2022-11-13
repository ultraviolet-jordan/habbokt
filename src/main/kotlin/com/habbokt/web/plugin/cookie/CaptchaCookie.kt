package com.habbokt.web.plugin.cookie

import com.habbokt.web.plugin.Authentications
import com.habbokt.web.session.CaptchaSession
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.SessionsConfig
import io.ktor.server.sessions.cookie

/**
 * @author Jordan Abraham
 */
fun SessionsConfig.installCaptchaCookie(
    encryptionKey: ByteArray,
    signKey: ByteArray
) {
    cookie<CaptchaSession>(Authentications.Captcha) {
        cookie.path = "/"
        cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
        // uses the AES and HmacSHA256 algorithms
        transform(SessionTransportTransformerEncrypt(encryptionKey, signKey))
    }
}
