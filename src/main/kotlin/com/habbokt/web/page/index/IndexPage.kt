package com.habbokt.web.page.index

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
class IndexPage(
    private val site: Site,
) : Page {
    override fun templateName(): String = "index.tpl"

    override fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = mapOf(
        "site" to site,
        "rememberMe" to parameters["rememberme"].toBoolean(),
        "username" to parameters["username"]
    )
}
