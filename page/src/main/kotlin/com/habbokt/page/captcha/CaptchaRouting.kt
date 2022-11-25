package com.habbokt.page.captcha

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Route
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class CaptchaRouting @Inject constructor(
    private val service: CaptchaService
) : PageRouting(Route {
    get("/captcha.jpg") {
        service.handleGetRequest(call)
    }
})