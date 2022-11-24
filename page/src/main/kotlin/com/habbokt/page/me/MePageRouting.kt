package com.habbokt.page.me

import com.google.inject.Inject
import com.habbokt.page.PageRouting
import com.habbokt.page.PageService
import io.ktor.server.application.call
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
class MePageRouting @Inject constructor(
    private val routing: Routing,
    private val service: PageService<MePage>
) : PageRouting {
    override fun bindRouting() = routing {
        get("/me") {
            service.handleGetRequest(call)
        }
    }
}