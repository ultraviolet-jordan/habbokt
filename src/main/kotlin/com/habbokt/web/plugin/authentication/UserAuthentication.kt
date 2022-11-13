package com.habbokt.web.plugin.authentication

import com.habbokt.web.session.UserSession
import io.ktor.server.auth.AuthenticationConfig
import io.ktor.server.auth.session
import io.ktor.server.response.respondRedirect

/**
 * @author Jordan Abraham
 */
fun AuthenticationConfig.installUserAuthentication() {
    session<UserSession>(Authentications.User) {
        validate { session ->
            if (session.authenticated) session
            else null
        }
        challenge {
            call.respondRedirect("/") // Homepage
        }
    }
}
