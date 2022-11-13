package com.habbokt.web.page.asset

import io.ktor.server.application.Application
import io.ktor.server.http.content.files
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticRootFolder
import io.ktor.server.routing.Route
import io.ktor.server.routing.routing
import java.io.File

/**
 * @author Jordan Abraham
 */
fun Application.installAssetsRoutes() {
    routing {
        routeStaticAssets("/")
    }
}

private fun Route.routeStaticAssets(path: String) {
    static(path) {
        staticRootFolder = File(this::class.java.classLoader.getResource("www")!!.toURI())
        files(".")
    }
}