package com.habbokt.page.asset

import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import io.ktor.server.http.content.staticResources

/**
 * @author Jordan Abraham
 */
@Singleton
class AssetPageRouting : PageRouting(
    routing = {
        staticResources("/", "www")
    }
)