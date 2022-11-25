package com.habbokt.page.register

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRoute
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get
import io.ktor.server.routing.post

/**
 * @author Jordan Abraham
 */
@Singleton
class RegisterPageRouting @Inject constructor(
    private val service: RegisterPageService
) : PageRouting {
    override fun route(): PageRoute = PageRoute {
        get("/register") {
            service.handleGetRequest(call)
        }
        authenticate(Authentications.Captcha) {
            post("/register") {
                service.handlePostRequest(call)
            }
        }
        get("/register/cancel") {
            service.handleCancelRequest(call)
        }
    }
}