package com.habbokt.page

import io.ktor.http.HttpHeaders
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header

/**
 * @author Jordan Abraham
 */
interface PageService<P : Page> {
    suspend fun respondPage(call: ApplicationCall, page: P)

    fun ApplicationCall.addHtmlHeaders(contentLength: Int) {
        response.header(HttpHeaders.ContentType, "text/html")
        response.header(HttpHeaders.ContentLength, contentLength)
    }
}
