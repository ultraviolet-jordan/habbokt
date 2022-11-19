package com.habbokt.web.page.account.submit

import com.habbokt.api.inject
import com.habbokt.dao.site.SiteService
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
object SubmitPage : Page {
    private val siteService by com.habbokt.api.inject<SiteService>()

    override fun templateName(): String = "account/submit.tpl"

    override suspend fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to siteService.site()
    )
}
