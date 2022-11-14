package com.habbokt.web.plugin.routes.account.submit

import com.habbokt.web.page.account.submit.SubmitPage
import com.habbokt.web.page.account.submit.SubmitPageService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installSubmitPageRoutes() {
    routing {
        postSubmitPage()
    }
}

private fun Route.postSubmitPage() {
    post("/account/submit") {
        SubmitPageService.respondPage(call, SubmitPage)
    }
}
