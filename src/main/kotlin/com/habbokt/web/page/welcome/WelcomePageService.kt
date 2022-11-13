package com.habbokt.web.page.welcome

import com.habbokt.web.common.htmlHeader
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
class WelcomePageService(
    private val compiler: Compiler
) : PageService<WelcomePage> {
    override suspend fun respondPage(call: ApplicationCall, page: WelcomePage) {
        val html = page.html(call.sessions, call.request.queryParameters, compiler)
        call.apply {
            htmlHeader(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
