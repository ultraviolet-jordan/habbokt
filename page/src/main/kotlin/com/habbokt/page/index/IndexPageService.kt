package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.session.UserSession
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respondRedirect
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPageService @Inject constructor(
    page: IndexPage,
    compiler: Compiler
) : PageService<IndexPage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        val sessions = call.sessions

        val userSession = sessions.get<UserSession>()
        // Have to hard check this since index page is not an authenticated page.
        if (userSession != null && userSession.authenticated) {
            call.respondRedirect("/me")
            return
        }

        call.respondHtmlPage()
    }
}