package com.habbokt.page.me

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.Route
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class MePageRouting @Inject constructor(
    private val service: MePageService
) : PageRouting(Route {
    authenticate(Authentications.User) {
        get("/me") {
            service.handleGetRequest(call)
        }
    }
})