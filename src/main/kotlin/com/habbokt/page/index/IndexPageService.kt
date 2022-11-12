package com.habbokt.page.index

import com.habbokt.compiler.Compiler
import com.habbokt.page.PageService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

/**
 * @author Jordan Abraham
 */
class IndexPageService(
    private val compiler: Compiler
) : PageService<IndexPage> {
    override suspend fun respondPage(call: ApplicationCall, page: IndexPage) {
        val html = page.html(call.request.queryParameters, compiler)
        call.addHtmlHeaders(html.length)
        call.respond(HttpStatusCode.OK, html)
    }
}