package com.habbokt.web.plugin.koin.welcome

import com.habbokt.web.inject
import com.habbokt.web.page.welcome.WelcomePage
import com.habbokt.web.page.welcome.WelcomePageService
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
private val welcomePageService by inject<WelcomePageService>()

fun Application.installWelcomePageRoutes() {
    routing {
        getWelcomePage()
    }
}

private fun Route.getWelcomePage() {
    authenticate(Authentications.User) {
        get("/welcome") {
            WelcomePageService.respondPage(call, WelcomePage)
        }
    }
}
