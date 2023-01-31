package com.habbokt.page.account.logout

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.session.UserSession
import com.habbokt.templating.Compiler
import io.ktor.server.application.ApplicationCall
import io.ktor.server.sessions.clear
import io.ktor.server.sessions.sessions

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountLogoutPageService @Inject constructor(
    page: AccountLogoutPage,
    compiler: Compiler
) : PageService<AccountLogoutPage>(page, compiler) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        call.sessions.clear<UserSession>()
        call.respondHtmlPage()
    }
}