package com.habbokt.page

import io.ktor.server.routing.Routing

/**
 * @author Jordan Abraham
 */
data class PageRoute(
    val block: Routing.() -> Unit
)
