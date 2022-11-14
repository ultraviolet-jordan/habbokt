package com.habbokt.web.plugin.koin.register

import com.habbokt.web.page.register.RegisterPage
import com.habbokt.web.page.register.RegisterPageService
import com.habbokt.web.plugin.Authentications
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installRegisterPageRoutes() {
    routing {
        getRegisterPage()
        postRegisterPage()
        getCancelRegister()
    }
}

private fun Route.getRegisterPage() {
    get("/register") {
        RegisterPageService.respondPage(call, RegisterPage)
    }
}

private fun Route.postRegisterPage() {
    authenticate(Authentications.Captcha) {
        post("/register") {
            RegisterPageService.respondRegistration(call)
        }
    }
}

private fun Route.getCancelRegister() {
    get("/register/cancel") {
        RegisterPageService.respondCancelRegistration(call)
    }
}
