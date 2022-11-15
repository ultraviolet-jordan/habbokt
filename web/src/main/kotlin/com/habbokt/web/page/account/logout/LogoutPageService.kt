package com.habbokt.web.page.account.logout

import com.habbokt.web.page.Page
import com.habbokt.web.page.PageService
import com.habbokt.web.session.UserSession
import io.ktor.server.application.ApplicationCall
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
object LogoutPageService : PageService {
    override suspend fun respondPage(call: ApplicationCall, page: Page) {
        // This page is authenticated by the user session.
        call.sessions.clear<UserSession>() // Remove session cookie.
        super.respondPage(call, page)
    }
}
