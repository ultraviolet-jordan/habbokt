package com.habbokt.web.page.habblet.ajax.namecheck

import com.habbokt.web.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
val nameCheckAjaxService by inject<NameCheckAjaxService>()

fun Application.installHabbletNameCheckAjaxRoute() {
    routing {
        postNameCheck("/habblet/ajax/namecheck")
    }
}

private fun Route.postNameCheck(path: String) {
    post(path) {
        nameCheckAjaxService.respondNameCheck(call)
    }
}
