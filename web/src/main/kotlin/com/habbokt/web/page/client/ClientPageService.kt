package com.habbokt.web.page.client

import com.habbokt.web.page.Page
import com.habbokt.web.page.PageService
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
object ClientPageService : PageService {
    override suspend fun respondPage(call: ApplicationCall, page: Page) {
        super.respondPage(call, page)
    }
}