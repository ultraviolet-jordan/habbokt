package com.habbokt.web.page.register

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installRegisterPageRoutes() {
    routing {
        routeRegisterPage("/register")
    }
}

private fun Route.routeRegisterPage(path: String) {
    get(path) {
        val registerPage by inject<RegisterPage>()
        val registerPageService by inject<RegisterPageService>()

        registerPageService.respondPage(call, registerPage)
    }
}
