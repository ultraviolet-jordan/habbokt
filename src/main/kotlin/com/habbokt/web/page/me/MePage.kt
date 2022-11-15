package com.habbokt.web.page.me

import com.habbokt.web.dao.site.SiteDAO
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object MePage : Page {
    private val dao by inject<SiteDAO>()

    override fun templateName(): String = "me.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to dao.site()
    )
}
