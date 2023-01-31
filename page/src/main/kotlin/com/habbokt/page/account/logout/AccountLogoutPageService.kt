package com.habbokt.page.account.logout

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage
import com.habbokt.session.UserSession
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountLogoutPageService : PageService<AccountLogoutPage>(
    get = {
        sessions.clear<UserSession>()
        respondHtmlPage(it)
    }
)
