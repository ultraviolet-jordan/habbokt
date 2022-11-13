package com.habbokt.web.page.error

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installErrorPageRoutes() {
    routing {
        routeErrorPage("/client_error")
    }
}

private fun Route.routeErrorPage(path: String) {
    get(path) {
        val errorPage by inject<ErrorPage>()
        val errorPageService by inject<ErrorPageService>()

        errorPageService.respondPage(call, errorPage)
    }
}
