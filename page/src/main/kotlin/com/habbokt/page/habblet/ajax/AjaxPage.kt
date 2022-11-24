package com.habbokt.page.habblet.ajax

import com.habbokt.page.Page
import com.habbokt.page.Template
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
class AjaxPage : Page<AjaxTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<AjaxTemplate> = Template {
        AjaxTemplate
    }
}