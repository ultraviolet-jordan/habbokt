package com.habbokt.web.page

import com.habbokt.web.common.htmlHeader
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
interface PageService {
    suspend fun respondPage(call: ApplicationCall, page: Page) {
        val html = page.html(call.sessions, call.request.queryParameters)
        call.apply {
            htmlHeader(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
