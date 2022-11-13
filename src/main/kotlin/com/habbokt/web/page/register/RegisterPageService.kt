package com.habbokt.web.page.register

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.compiler.Compiler
import com.habbokt.web.page.PageService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

/**
 * @author Jordan Abraham
 */
class RegisterPageService(
    private val compiler: Compiler
) : PageService<RegisterPage> {
    override suspend fun respondPage(call: ApplicationCall, page: RegisterPage) {
        val html = page.html(call.request.queryParameters, compiler)
        call.apply {
            htmlHeaders(html.length)
        }.respond(HttpStatusCode.OK, html)
    }
}
