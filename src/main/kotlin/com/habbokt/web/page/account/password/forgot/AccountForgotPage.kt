package com.habbokt.web.page.account.password.forgot

import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object AccountForgotPage : Page {
    override fun templateName(): String = "account/email/account_forgot.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = emptyMap()
}