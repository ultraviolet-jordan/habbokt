package com.habbokt.page

import io.ktor.server.routing.Routing

/**
 * @author Jordan Abraham
 *
 * @see Page
 * @see PageRequest
 * @see PageService
 *
 * @constructor Creates a new [Routing] for a specified html page.
 *
 * @property routing The routing used for the http requests for a html page.
 */
abstract class PageRouting(
    val routing: Routing.() -> Unit
)