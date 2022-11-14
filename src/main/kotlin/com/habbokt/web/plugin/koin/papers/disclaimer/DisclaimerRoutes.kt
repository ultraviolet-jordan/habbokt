package com.habbokt.web.plugin.koin.papers.disclaimer

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installDisclaimerRoutes() {
    routing {
        getPapersDisclaimer()
    }
}

private fun Route.getPapersDisclaimer() {
    get("/papers/disclaimer") {
        call.respondRedirect("/") // Homepage.
    }
}
