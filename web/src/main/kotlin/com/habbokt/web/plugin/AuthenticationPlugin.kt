package com.habbokt.web.plugin

import com.habbokt.web.plugin.auth.installCaptchaAuthentication
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication

/**
 * @author Jordan Abraham
 */
fun Application.installAuthenticationPlugin() {
    install(Authentication) {
        installCaptchaAuthentication()
    }
}

sealed class Authentications {
    companion object {
        const val Captcha = "captcha_session"
        const val Registration = "registration_session"
        const val User = "user_session"
    }
}