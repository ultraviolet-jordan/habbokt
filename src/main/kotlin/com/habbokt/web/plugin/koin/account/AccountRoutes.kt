package com.habbokt.web.plugin.koin.account

import com.habbokt.web.plugin.koin.account.logout.installLogoutRoutes
import com.habbokt.web.plugin.koin.account.password.forgot.installAccountForgotRoutes
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installAccountPageRoutes() {
    installLogoutRoutes()
    installAccountForgotRoutes()
}
