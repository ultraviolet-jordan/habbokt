package com.habbokt.page

import io.ktor.server.routing.Routing

/**
 * @author Jordan Abraham
 */
abstract class PageRouting(
    val routing: Routing.() -> Unit
)