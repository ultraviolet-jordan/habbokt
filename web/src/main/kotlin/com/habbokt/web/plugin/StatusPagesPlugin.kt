package com.habbokt.web.plugin

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.request.uri
import io.ktor.server.response.respondRedirect

/**
 * @author Jordan Abraham
 */
fun Application.installStatusPagesPlugin() {
    val assets = listOf(
        "/c_images",
        "/dcr",
        "/flash",
        "/habbo-imaging",
        "/images",
        "/public",
        "/web-gallery",
        "/xml",
        "/js",
        "/styles",
        "/cdn-cgi"
    )

    install(StatusPages) {
        exception<Exception> { call, cause ->
            call.application.environment.log.error("Exception caught. Redirecting to /", cause)
            call.respondRedirect("/")
        }
        status(HttpStatusCode.NotFound) { call, _ ->
            if (assets.any { call.request.uri.startsWith(it) }) return@status
            call.respondRedirect("/")
        }
    }
}