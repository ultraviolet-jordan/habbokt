package com.habbokt.web.plugin.routes.habblet.ajax.namecheck

import com.habbokt.web.page.habblet.ajax.namecheck.NameCheckAjaxService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installHabbletNameCheckAjaxRoute() {
    routing {
        postNameCheck()
    }
}

private fun Route.postNameCheck() {
    post("/habblet/ajax/namecheck") {
        NameCheckAjaxService.respondNameCheck(call)
    }
}
