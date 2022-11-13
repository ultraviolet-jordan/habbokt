package com.habbokt.web.page.habblet

import com.habbokt.web.page.habblet.ajax.namecheck.installHabbletNameCheckAjaxRoute
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installHabbletRoutes() {
    installHabbletNameCheckAjaxRoute()
}
