package com.habbokt.web.plugin

import com.habbokt.web.session.CaptchaSession
import com.habbokt.web.session.RegistrationSession
import com.habbokt.web.session.UserSession
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.sessions.SessionTransportTransformerEncrypt
import io.ktor.server.sessions.Sessions
import io.ktor.server.sessions.cookie
import io.ktor.util.hex

/**
 * @author Jordan Abraham
 */
fun Application.installSessionsPlugin() {
    install(Sessions) {
        val secretEncryptKey = hex(this@installSessionsPlugin.environment.config.property("sessions.secret.encryption").getString())
        val secretSignKey = hex(this@installSessionsPlugin.environment.config.property("sessions.secret.signing").getString())
        cookie<CaptchaSession>("captcha_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
            // uses the AES and HmacSHA256 algorithms
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretSignKey))
        }
        cookie<RegistrationSession>("registration_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
            // uses the AES and HmacSHA256 algorithms
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretSignKey))
        }
        cookie<UserSession>("user_session") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 1 * 60 * 10 // 10 Minutes
            // uses the AES and HmacSHA256 algorithms
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretSignKey))
        }
    }
}
