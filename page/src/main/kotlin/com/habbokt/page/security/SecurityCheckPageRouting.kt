package com.habbokt.page.security

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.Route
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class SecurityCheckPageRouting @Inject constructor(
    private val service: SecurityCheckPageService
) : PageRouting(Route {
    authenticate(Authentications.User) {
        get("/security_check") {
            service.handleGetRequest(call)
        }
    }
})