package com.habbokt.web.plugin.routes.security

import com.habbokt.web.page.security.SecurityCheckPage
import com.habbokt.web.page.security.SecurityCheckPageService
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
fun Application.installSecurityPageRoutes() {
    routing {
        getSecurityPage()
    }
}

private fun Route.getSecurityPage() {
    authenticate(Authentications.User) {
        get("/security_check") {
            SecurityCheckPageService.respondPage(call, SecurityCheckPage)
        }
    }
}
