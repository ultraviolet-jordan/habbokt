package com.habbokt.web.plugin.routes.account

import com.habbokt.web.plugin.routes.account.logout.installLogoutRoutes
import com.habbokt.web.plugin.routes.account.password.forgot.installAccountForgotRoutes
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installAccountPageRoutes() {
    installLogoutRoutes()
    installAccountForgotRoutes()
}
