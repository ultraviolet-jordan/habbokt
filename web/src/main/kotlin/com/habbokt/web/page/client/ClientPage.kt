package com.habbokt.web.page.client

import com.habbokt.dao.site.SiteDAO
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import java.util.UUID

/**
 * @author Jordan Abraham
 */
object ClientPage : Page {
    private val dao by inject<SiteDAO>()

    override fun templateName(): String = "client.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to dao.site(),
        "ssoTicket" to UUID.randomUUID().toString(),
        "forwardRoom" to false
    )
}