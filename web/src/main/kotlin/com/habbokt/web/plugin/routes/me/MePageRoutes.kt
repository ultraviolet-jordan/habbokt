package com.habbokt.web.plugin.routes.me

import com.habbokt.web.page.me.MePage
import com.habbokt.web.page.me.MePageService
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
fun Application.installMePageRoutes() {
    routing {
        getMePage()
    }
}

private fun Route.getMePage() {
    authenticate(Authentications.User) {
        get("/me") {
            MePageService.respondPage(call, MePage)
        }
    }
}
