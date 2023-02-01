package com.habbokt.page.welcome

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class WelcomePageRouting @Inject constructor(
    private val service: WelcomePageService
) : PageRouting(
    routing = {
        authenticate(Authentications.User) {
            get("/welcome") {
                call.respondHtml(HttpStatusCode.OK, service.getRequest(WelcomePageRequest.Empty))
            }
        }
    }
)