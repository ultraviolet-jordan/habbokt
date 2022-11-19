package com.habbokt.web.page.error

import com.habbokt.api.inject
import com.habbokt.dao.site.SiteService
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object ErrorPage : Page {
    private val dao by com.habbokt.api.inject<SiteService>()

    override fun templateName(): String = "client_error.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to dao.site(),
        "error_id" to parameters["error_id"]
    )
}
