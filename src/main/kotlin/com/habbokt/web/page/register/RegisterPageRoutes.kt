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
private val registerPage by inject<RegisterPage>()
private val registerPageService by inject<RegisterPageService>()

fun Application.installRegisterPageRoutes() {
    routing {
        getRegisterPage()
        postRegisterPage()
        getCancelRegister()
    }
}

private fun Route.getRegisterPage() {
    get("/register") {
        registerPageService.respondPage(call, registerPage)
    }
}

private fun Route.postRegisterPage() {
    post("/register") {
        registerPageService.respondRegistration(call)
    }
}

private fun Route.getCancelRegister() {
    get("/register/cancel") {
        registerPageService.respondCancelRegistration(call)
    }
}
