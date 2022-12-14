package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.page.Template
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPage @Inject constructor(
   private val siteService: SiteService
) : Page<IndexPageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<IndexPageTemplate> = Template {
        IndexPageTemplate(
            site = siteService.site(),
            rememberMe = parameters["rememberme"].toBoolean(),
            username = parameters["username"]
        )
    }
}