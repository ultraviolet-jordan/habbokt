package com.habbokt.web.plugin.routes.papers.privacy

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installPrivacyRoutes() {
    routing {
        getPapersPrivacy()
    }
}

private fun Route.getPapersPrivacy() {
    get("/papers/privacy") {
        call.respondRedirect("/") // Homepage.
    }
}
