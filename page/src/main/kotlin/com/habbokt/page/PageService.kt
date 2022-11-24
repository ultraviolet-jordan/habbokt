package com.habbokt.page

import com.habbokt.templating.Compiler
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header
import io.ktor.server.response.respond
import io.ktor.server.sessions.sessions
import java.io.StringWriter

/**
 * @author Jordan Abraham
 */
abstract class PageService<P : Page<*>>(
    private val page: P,
    private val compiler: Compiler
) {
    open suspend fun handleGetRequest(call: ApplicationCall) {}
    open suspend fun handlePostRequest(call: ApplicationCall) {}

    protected suspend fun ApplicationCall.respondHtmlPage() {
        val template = page.template(
            sessions = sessions,
            parameters = request.queryParameters
        ).block.invoke()
        val html = StringWriter().apply {
            compiler.compile(this, template.path, template)
        }.toString()
        htmlHeader(html.length)
        respond(HttpStatusCode.OK, html)
    }

    private fun ApplicationCall.htmlHeader(contentLength: Int) {
        response.header(HttpHeaders.ContentType, "text/html")
        response.header(HttpHeaders.ContentLength, contentLength)
    }

    private fun ApplicationCall.xjsonHeader(json: String) {
        response.header("X-JSON", json)
    }

    private fun ApplicationCall.pngHeader(contentLength: Int) {
        response.header(HttpHeaders.ContentType, "image/png")
        response.header(HttpHeaders.ContentLength, contentLength)
    }
}