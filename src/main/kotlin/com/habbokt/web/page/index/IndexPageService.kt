package com.habbokt.web.page.index

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import com.habbokt.web.session.UserSession
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
class IndexPageService(
    private val compiler: Compiler
) : PageService<IndexPage> {
    override suspend fun respondPage(call: ApplicationCall, page: IndexPage) {
        val sessions = call.sessions

        val userSession = sessions.get<UserSession>()
        // Have to hard check this since index page is not an authenticated page.
        if (userSession != null && userSession.authenticated) {
            call.respondRedirect("/me")
            return
        }

        val html = page.html(sessions, call.request.queryParameters, compiler)
        call.apply {
            htmlHeaders(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
