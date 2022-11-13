package com.habbokt.web.page.welcome

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
val welcomePage by inject<WelcomePage>()
val welcomePageService by inject<WelcomePageService>()

fun Application.installWelcomePageRoutes() {
    routing {
        getWelcomePage()
    }
}

private fun Route.getWelcomePage() {
    authenticate("user_session") {
        get("/welcome") {
            welcomePageService.respondPage(call, welcomePage)
        }
    }
}
