package com.habbokt.web.page.index

import com.habbokt.web.inject
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
        indexPageRoute("/")
        indexPageRoute("/index")
        indexPageRoute("/home")
    }
}

private fun Route.indexPageRoute(path: String) {
    get(path) {
        val indexPage by inject<IndexPage>()
        val indexPageService by inject<IndexPageService>()

        indexPageService.respondPage(call, indexPage)
    }
}
