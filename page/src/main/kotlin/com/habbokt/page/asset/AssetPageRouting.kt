package com.habbokt.page.asset

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import io.ktor.server.http.content.files
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticRootFolder
import io.ktor.server.routing.Routing
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
class AssetPageRouting @Inject constructor(
    private val routing: Routing
) : PageRouting {
    override fun configure() = routing {
        static("/") {
            staticRootFolder = File(this::class.java.classLoader.getResource("www")!!.toURI())
            files(".")
        }
    }
}