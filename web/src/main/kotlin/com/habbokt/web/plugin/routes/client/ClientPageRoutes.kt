package com.habbokt.web.plugin.routes.client

import com.habbokt.web.page.client.ClientPage
import com.habbokt.web.page.client.ClientPageService
import com.habbokt.web.plugin.Authentications
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installClientPageRoutes() {
    routing {
        getClientPage()
    }
}

private fun Route.getClientPage() {
    authenticate(Authentications.User) {
        get("/client") {
            ClientPageService.respondPage(call, ClientPage)
        }
    }
}