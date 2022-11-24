package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.PageRoute
import io.ktor.server.application.call
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPageRouting @Inject constructor(
    private val service: IndexPageService
) : PageRouting {
    override fun route(): PageRoute = PageRoute {
        get("/") {
            service.handleGetRequest(call)
        }
    }
}