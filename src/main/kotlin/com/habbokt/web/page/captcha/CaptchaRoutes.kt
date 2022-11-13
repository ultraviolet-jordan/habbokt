package com.habbokt.web.page.captcha

import com.habbokt.web.common.pngHeader
import com.habbokt.web.inject
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installCaptchaRoutes() {
    routing {
        getCaptcha("/captcha.jpg")
    }
}

private fun Route.getCaptcha(path: String) {
    get(path) {
        val captchaService by inject<CaptchaService>()
        val captcha = captchaService.getCaptchaResponse(call)

        call.apply {
            pngHeader(captcha.size)
        }.respond(HttpStatusCode.OK, captcha)
    }
}
