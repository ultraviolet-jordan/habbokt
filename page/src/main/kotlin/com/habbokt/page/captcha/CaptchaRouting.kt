package com.habbokt.page.captcha

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRoute
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class CaptchaRouting @Inject constructor(
    private val service: CaptchaService
) : PageRouting {
    override fun route(): PageRoute = PageRoute {
        get("/captcha.jpg") {
            service.handleGetRequest(call)
        }
    }
}