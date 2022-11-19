package com.habbokt.web.page.index

import com.habbokt.dao.site.SiteService
import com.habbokt.web.inject
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object IndexPage : Page {
    private val dao by inject<SiteService>()

    override fun templateName(): String = "index.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to dao.site(),
        "rememberMe" to parameters["rememberme"].toBoolean(),
        "username" to parameters["username"]
    )
}
