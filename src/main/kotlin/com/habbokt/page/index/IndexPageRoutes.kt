package com.habbokt.page.index

import com.habbokt.inject
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

/**
 * @author Jordan Abraham
 */
fun Application.installIndexPage() {
    routing {
        get("/") {
            val indexPage by inject<IndexPage>()
            val indexPageService by inject<IndexPageService>()

            indexPageService.respondPage(call, indexPage)
        }
    }
}