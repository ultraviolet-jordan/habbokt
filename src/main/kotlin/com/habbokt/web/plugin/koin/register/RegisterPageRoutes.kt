package com.habbokt.web.plugin.koin.register

import com.habbokt.web.inject
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
    authenticate(Authentications.Captcha) {
        post("/register") {
            registerPageService.respondRegistration(call)
        }
    }
}

private fun Route.getCancelRegister() {
    get("/register/cancel") {
        registerPageService.respondCancelRegistration(call)
    }
}
