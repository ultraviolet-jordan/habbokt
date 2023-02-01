package com.habbokt.page.client

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.get
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientPageRouting @Inject constructor(
    private val service: ClientPageService
) : PageRouting(
    routing = {
        authenticate(Authentications.User) {
            get("/client") {
                val request = ClientPageRequest(
                    userSession = call.sessions.get()!!
                )
                call.respondHtml(HttpStatusCode.OK, service.getRequest(request))
            }
        }
    }
)