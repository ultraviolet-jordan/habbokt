package com.habbokt.page.asset

import com.google.inject.Singleton
import com.habbokt.page.PageRoute
import com.habbokt.page.PageRouting
import io.ktor.server.http.content.files
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticRootFolder
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
class AssetPageRouting : PageRouting {
    override fun route(): PageRoute = PageRoute {
        static("/") {
            staticRootFolder = File(this::class.java.classLoader.getResource("www")!!.toURI())
            files(".")
        }
    }
}