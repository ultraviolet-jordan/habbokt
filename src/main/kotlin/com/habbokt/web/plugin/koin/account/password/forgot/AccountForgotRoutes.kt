package com.habbokt.web.plugin.koin.account.password.forgot

import com.habbokt.web.page.account.password.forgot.AccountForgotPage
import com.habbokt.web.page.account.password.forgot.AccountForgotPageService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installAccountForgotRoutes() {
    routing {
        getAccountForgotPage()
    }
}

private fun Route.getAccountForgotPage() {
    get("/account/password/forgot") {
        AccountForgotPageService.respondPage(call, AccountForgotPage)
    }
}
