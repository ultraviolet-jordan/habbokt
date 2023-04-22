package com.habbokt.page.asset

import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import io.ktor.server.http.content.files
import io.ktor.server.http.content.static
import io.ktor.server.http.content.staticResources
import io.ktor.server.http.content.staticRootFolder
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
class AssetPageRouting : PageRouting(
    routing = {
        staticResources("/", "www")
    }
)