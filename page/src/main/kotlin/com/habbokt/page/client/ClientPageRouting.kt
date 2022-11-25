package com.habbokt.page.client

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRoute
import com.habbokt.page.PageRouting
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientPageRouting @Inject constructor(
    private val service: ClientPageService
) : PageRouting {
    override fun route(): PageRoute = PageRoute {
        authenticate(Authentications.User) {
            get("/client") {
                service.handleGetRequest(call)
            }
        }
    }
}