package com.habbokt.web.page.captcha

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
val captchaService by inject<CaptchaService>()

fun Application.installCaptchaRoutes() {
    routing {
        getCaptcha("/captcha.jpg")
    }
}

private fun Route.getCaptcha(path: String) {
    get(path) {
        captchaService.respondCaptcha(call)
    }
}
