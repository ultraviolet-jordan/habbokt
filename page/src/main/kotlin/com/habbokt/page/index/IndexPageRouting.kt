package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.Route
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPageRouting @Inject constructor(
    private val service: IndexPageService
) : PageRouting(Route {
    get("/") {
        service.handleGetRequest(call)
    }
})