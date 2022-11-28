package com.habbokt.page.security

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
class SecurityCheckPage @Inject constructor(
    private val siteService: SiteService
) : Page<SecurityCheckPageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<SecurityCheckPageTemplate> = Template {
        SecurityCheckPageTemplate(
            site = siteService.site(),
            redirectPath = "/me" // TODO or /welcome
        )
    }
}