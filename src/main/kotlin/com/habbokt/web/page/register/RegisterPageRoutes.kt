package com.habbokt.web.page.register

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.server.sessions.get
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
val registerPage by inject<RegisterPage>()
val registerPageService by inject<RegisterPageService>()

fun Application.installRegisterPageRoutes() {
    routing {
        getRegisterPage("/register")
        postRegisterPage("/register")
    }
}

private fun Route.getRegisterPage(path: String) {
    get(path) {
        registerPageService.respondPage(call, registerPage)
    }
}

private fun Route.postRegisterPage(path: String) {
    post(path) {
        registerPageService.respondRegistration(call)
    }
}
