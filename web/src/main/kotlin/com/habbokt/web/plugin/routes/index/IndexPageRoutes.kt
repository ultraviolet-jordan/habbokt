package com.habbokt.web.plugin.routes.index

import com.habbokt.web.page.index.IndexPage
import com.habbokt.web.page.index.IndexPageService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installIndexPageRoutes() {
    routing {
        getIndexPage("/")
        getIndexPage("/index")
        getIndexPage("/home")
    }
}

private fun Route.getIndexPage(path: String) {
    get(path) {
        IndexPageService.respondPage(call, IndexPage)
    }
}
