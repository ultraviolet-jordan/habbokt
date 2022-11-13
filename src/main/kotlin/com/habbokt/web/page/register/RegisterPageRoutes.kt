package com.habbokt.web.page.register

import com.habbokt.web.inject
import com.habbokt.web.session.CaptchaSession
import com.habbokt.web.session.RegistrationSession
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.set

/**
 * @author Jordan Abraham
 */
val registerPage by inject<RegisterPage>()
val registerPageService by inject<RegisterPageService>()

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
        val sessions = call.sessions
        sessions.clear<CaptchaSession>()
        sessions.clear<RegistrationSession>()
        call.respondRedirect("/") // Homepage
    }
}
