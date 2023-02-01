package com.habbokt.page.captcha

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.respondPng
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class CaptchaRouting @Inject constructor(
    private val service: CaptchaService
) : PageRouting(
    routing = {
        get("/captcha.jpg") {
            val request = CaptchaRequest(
                session = call.sessions
            )
            call.respondPng(HttpStatusCode.OK, service.getRequest(request))
        }
    }
)