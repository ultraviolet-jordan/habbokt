package com.habbokt.asset

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
fun Application.installAssets() {
    routing {
        staticAssetsRoute()
    }
}

private fun Route.staticAssetsRoute() {
    static("/") {
        staticRootFolder = File(this::class.java.classLoader.getResource("www")!!.toURI())
        files(".")
    }
}