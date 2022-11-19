package com.habbokt.web.page.security

import com.habbokt.api.inject
import com.habbokt.dao.site.SiteService
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object SecurityCheckPage : Page {
    private val siteService by inject<SiteService>()

    override fun templateName(): String = "security_check.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to siteService.site(),
        "redirectPath" to "/me"
    )
}
