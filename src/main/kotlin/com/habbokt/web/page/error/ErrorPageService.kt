package com.habbokt.web.page.error

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

/**
 * @author Jordan Abraham
 */
class ErrorPageService(
    private val compiler: Compiler
) : PageService<ErrorPage> {
    override suspend fun respondPage(call: ApplicationCall, page: ErrorPage) {
        val html = page.html(call.request.queryParameters, compiler)
        call.apply {
            htmlHeaders(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
