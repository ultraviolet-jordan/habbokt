package com.habbokt.web.plugin.koin.account

import com.habbokt.web.page.account.logout.LogoutPage
import com.habbokt.web.page.account.logout.LogoutPageService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installAccountPageRoutes() {
    routing {
        getAccountLogout()
    }
}

private fun Route.getAccountLogout() {
    get("/account/logout") {
        LogoutPageService.respondPage(call, LogoutPage)
    }
}
