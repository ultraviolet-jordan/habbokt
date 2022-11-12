package com.habbokt.web.plugin

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondRedirect

/**
 * @author Jordan Abraham
 */
fun Application.installStatusPagesPlugin() {
    install(StatusPages) {
        exception<RuntimeException> { call, cause ->
            call.application.environment.log.error("RuntimeException caught. Redirecting to /client_error...", cause)
            call.respondRedirect("/client_error")
        }
    }
}
