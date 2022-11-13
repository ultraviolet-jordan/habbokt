package com.habbokt.web.common

import io.ktor.http.HttpHeaders
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.header

/**
 * @author Jordan Abraham
 */
fun ApplicationCall.htmlHeaders(contentLength: Int) {
    response.header(HttpHeaders.ContentType, "text/html")
    response.header(HttpHeaders.ContentLength, contentLength)
}

fun ApplicationCall.xjsonHeader(json: String) {
    response.header("X-JSON", json)
}
