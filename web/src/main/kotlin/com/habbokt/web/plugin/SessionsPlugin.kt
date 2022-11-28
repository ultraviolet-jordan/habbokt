package com.habbokt.web.plugin

import com.habbokt.web.plugin.cookie.installCaptchaCookie
import com.habbokt.web.plugin.cookie.installRegistrationCookie
import com.habbokt.web.plugin.cookie.installUserCookie
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.sessions.Sessions
import io.ktor.util.hex

/**
 * @author Jordan Abraham
 */
fun Application.installSessionsPlugin() {
    install(Sessions) {
        val encryptionKey = hex(this@installSessionsPlugin.environment.config.property("sessions.secret.encryption").getString())
        val signKey = hex(this@installSessionsPlugin.environment.config.property("sessions.secret.signing").getString())

        installCaptchaCookie(encryptionKey, signKey)
        installRegistrationCookie(encryptionKey, signKey)
        installUserCookie(encryptionKey, signKey)
    }
}