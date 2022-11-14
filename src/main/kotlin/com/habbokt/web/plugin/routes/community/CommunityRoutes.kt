package com.habbokt.web.plugin.routes.community

import com.habbokt.web.page.community.CommunityPage
import com.habbokt.web.page.community.CommunityPageService
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installCommunityRoutes() {
    routing {
        getCommunityPage()
    }
}

private fun Route.getCommunityPage() {
    get("/community") {
        CommunityPageService.respondPage(call, CommunityPage)
    }
}