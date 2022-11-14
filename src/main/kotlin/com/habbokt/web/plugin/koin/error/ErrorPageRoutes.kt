package com.habbokt.web.plugin.koin.error

import com.habbokt.web.page.error.ErrorPage
import com.habbokt.web.page.error.ErrorPageService
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
        getErrorPage()
    }
}

private fun Route.getErrorPage() {
    get("/client_error") {
        ErrorPageService.respondPage(call, ErrorPage)
    }
}
