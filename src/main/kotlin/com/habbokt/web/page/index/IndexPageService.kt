package com.habbokt.web.page.index

import com.habbokt.web.page.Page
import com.habbokt.web.page.PageService
import com.habbokt.web.session.UserSession
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
object IndexPageService : PageService {

    override suspend fun respondPage(call: ApplicationCall, page: Page) {
        val sessions = call.sessions

        val userSession = sessions.get<UserSession>()
        // Have to hard check this since index page is not an authenticated page.
        if (userSession != null && userSession.authenticated) {
            call.respondRedirect("/me")
            return
        }

        super.respondPage(call, page)
    }
}
