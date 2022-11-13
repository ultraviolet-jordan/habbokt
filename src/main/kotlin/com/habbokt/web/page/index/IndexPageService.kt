package com.habbokt.web.page.index

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
class IndexPageService(
    private val compiler: Compiler
) : PageService<IndexPage> {
    override suspend fun respondPage(call: ApplicationCall, page: IndexPage) {
        val html = page.html(call.sessions, call.request.queryParameters, compiler)
        call.apply {
            htmlHeaders(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
