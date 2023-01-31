package com.habbokt.page.index

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage
import com.habbokt.session.UserSession
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPageService : PageService<IndexPage>(
    get = response@{
        val userSession = sessions.get<UserSession>()
        // Have to hard check this since index page is not an authenticated page.
        if (userSession != null && userSession.authenticated) {
            return@response respondRedirect("/me")
        }

        return@response respondHtmlPage(it)
    }
)