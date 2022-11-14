package com.habbokt.web.page.welcome

import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
class WelcomePage : Page {
    override fun templateName(): String = "welcome.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = emptyMap()
}
