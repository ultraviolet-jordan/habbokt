package com.habbokt.web.page.habblet.ajax.namecheck

import com.habbokt.web.common.htmlHeaders
import com.habbokt.web.common.xjsonHeader
import com.habbokt.web.inject
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installHabbletNameCheckAjaxRoute() {
    routing {
        postNameCheck("/habblet/ajax/namecheck")
    }
}

private fun Route.postNameCheck(path: String) {
    post(path) {
        val nameCheckAjaxService by inject<NameCheckAjaxService>()
        val response = nameCheckAjaxService.getNameCheckFormResponse(call)

        call.apply {
            xjsonHeader(
                """
                    {"registration_name":"${response.string}"}
                """.trimIndent()
            )
            htmlHeaders(0)
        }.respond(HttpStatusCode.OK)
    }
}
