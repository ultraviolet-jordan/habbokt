package com.habbokt.page.me

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Authentications
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import com.habbokt.session.UserSession
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
class MePageRouting @Inject constructor(
    private val service: MePageService
) : PageRouting(
    routing = {
        authenticate(Authentications.User) {
            get("/me") {
                val request = MePageRequest(
                    userId = call.sessions.get<UserSession>()!!.userId.toInt()
                )
                call.respondHtml(HttpStatusCode.OK, service.getRequest(request))
            }
        }
    }
)