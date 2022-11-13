package com.habbokt.web.plugin

import com.habbokt.web.session.UserSession
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect

/**
 * @author Jordan Abraham
 */
fun Application.installAuthenticationPlugin() {
    install(Authentication) {
        session<UserSession>("user_session") {
            validate { session ->
                if (session.authenticated) session
                else null
            }
            challenge {
                call.respondRedirect("/") // Homepage
            }
        }
    }
}
