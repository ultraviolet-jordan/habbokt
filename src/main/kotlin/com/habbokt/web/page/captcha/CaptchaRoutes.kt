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
private val captchaService by inject<CaptchaService>()

fun Application.installCaptchaRoutes() {
    routing {
        getCaptcha()
    }
}

private fun Route.getCaptcha() {
    get("/captcha.jpg") {
        captchaService.respondCaptcha(call)
    }
}
