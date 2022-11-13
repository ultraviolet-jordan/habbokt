package com.habbokt.web.plugin.koin.habblet

import com.habbokt.web.plugin.koin.habblet.ajax.namecheck.installHabbletNameCheckAjaxRoute
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installHabbletRoutes() {
    installHabbletNameCheckAjaxRoute()
}
