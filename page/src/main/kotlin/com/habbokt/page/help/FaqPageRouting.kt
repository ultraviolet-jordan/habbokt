package com.habbokt.page.help

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import com.habbokt.session.UserSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class FaqPageRouting @Inject constructor(
    private val service: FaqPageService
) : PageRouting(
    routing = {
        get("/help/{helpId?}") {
            val request = FaqPageRequest(
                helpId = call.parameters["helpId"]?.toIntOrNull(),
                userId = call.sessions.get<UserSession>()?.userId?.toInt()
            )
            call.respondHtml(HttpStatusCode.OK, service.getRequest(request))
        }
    }
)