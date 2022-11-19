package com.habbokt.web.page.index

import com.habbokt.api.inject
import com.habbokt.dao.site.SiteService
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object IndexPage : Page {
    private val siteService by inject<SiteService>()

    override fun templateName(): String = "index.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to siteService.site(),
        "rememberMe" to parameters["rememberme"].toBoolean(),
        "username" to parameters["username"]
    )
}
