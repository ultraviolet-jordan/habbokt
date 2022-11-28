package com.habbokt.web.plugin

import com.habbokt.web.plugin.auth.installCaptchaAuthentication
import com.habbokt.web.plugin.auth.installUserAuthentication
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication

/**
 * @author Jordan Abraham
 */
fun Application.installAuthenticationPlugin() {
    install(Authentication) {
        installCaptchaAuthentication()
        installUserAuthentication()
    }
}