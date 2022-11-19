package com.habbokt.web.plugin

import com.habbokt.web.exception.ExpiredCookieException
import com.habbokt.web.session.UserSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.request.uri
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
fun Application.installStatusPagesPlugin() {
    val assets = listOf(
        "/c_images",
        "/dcr",
        "/flash",
        "/habbo-imaging",
        "/images",
        "/public",
        "/web-gallery",
        "/xml",
        "/js",
        "/styles",
        "/cdn-cgi"
    )

    install(StatusPages) {
        exception<RuntimeException> { call, cause ->
            call.application.environment.log.error("RuntimeException caught. Redirecting to /client_error...", cause)
            call.respondRedirect("/client_error")
        }
        exception<ExpiredCookieException> { call, _ ->
            // CipherException used for things like cookies.
            // If the cookie is invalid, this will throw. We can remove the cookie from the user here and redirect them.
            val sessions = call.sessions
            if (sessions.get<UserSession>() != null) {
                sessions.clear<UserSession>()
            }
            call.respondRedirect("/")
        }
        exception<Exception> { call, cause ->
            call.application.environment.log.error("Exception caught. Redirecting to /...", cause)
            call.respondRedirect("/")
        }
        status(HttpStatusCode.NotFound) { call, _ ->
            if (assets.any { call.request.uri.startsWith(it) }) return@status
            call.respondRedirect("/")
        }
    }
}
