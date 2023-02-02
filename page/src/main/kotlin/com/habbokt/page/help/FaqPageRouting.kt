package com.habbokt.page.help

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class FaqPageRouting @Inject constructor(
    private val service: FaqPageService
) : PageRouting(
    routing = {
        get("/help") {
            call.respondHtml(HttpStatusCode.OK, service.getRequest(FaqPageRequest.Empty))
        }
    }
)