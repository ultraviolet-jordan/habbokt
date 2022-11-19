package com.habbokt.web.page.community

import com.habbokt.dao.site.SiteService
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object CommunityPage : Page {
    private val dao by inject<SiteService>()

    override fun templateName(): String = "community.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to dao.site()
    )
}
