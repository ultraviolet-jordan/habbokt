package com.habbokt.web.page.me

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.auth.authenticate
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
private val mePage by inject<MePage>()
private val mePageService by inject<MePageService>()

fun Application.installMePageRoutes() {
    routing {
        getMePage()
    }
}

private fun Route.getMePage() {
    authenticate("user_session") {
        get("/me") {
            mePageService.respondPage(call, mePage)
        }
    }
}