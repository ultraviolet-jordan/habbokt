package com.habbokt.web.plugin.auth

import com.habbokt.page.Authentications
import com.habbokt.session.UserSession
import io.ktor.server.auth.AuthenticationConfig
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
fun AuthenticationConfig.installUserAuthentication() {
    session<UserSession>(Authentications.User) {
        validate { session ->
            if (session.userId.toIntOrNull() != 0) session // Validate session cipher.
            else if (session.authenticated) session // Validate user session flag.
            else null
        }
        challenge {
            if (it != null) {
                call.sessions.clear<UserSession>()
            }
            call.respondRedirect("/") // Homepage
        }
    }
}