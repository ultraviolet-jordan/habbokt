package com.habbokt.web.page.me

import com.habbokt.web.model.Site
import com.habbokt.web.page.Page
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
class MePage(
    private val site: Site
) : Page {
    override fun templateName(): String  = "me.tpl"

    override fun context(sessions: CurrentSession, parameters: Parameters): Map<String, Any?> = emptyMap()
}