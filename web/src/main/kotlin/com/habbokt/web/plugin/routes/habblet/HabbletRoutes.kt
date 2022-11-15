package com.habbokt.web.plugin.routes.habblet

import com.habbokt.web.plugin.routes.habblet.ajax.namecheck.installHabbletNameCheckAjaxRoute
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installHabbletRoutes() {
    installHabbletNameCheckAjaxRoute()
}
