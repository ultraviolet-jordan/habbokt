package com.habbokt.web.page.account.logout

import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object LogoutPage : Page {
    override fun templateName(): String = "account/logout.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = emptyMap()
}
