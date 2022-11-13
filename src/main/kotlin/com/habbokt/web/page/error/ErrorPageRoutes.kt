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
val errorPage by inject<ErrorPage>()
val errorPageService by inject<ErrorPageService>()

fun Application.installErrorPageRoutes() {
    routing {
        getErrorPage()
    }
}

private fun Route.getErrorPage() {
    get("/client_error") {
        errorPageService.respondPage(call, errorPage)
    }
}
