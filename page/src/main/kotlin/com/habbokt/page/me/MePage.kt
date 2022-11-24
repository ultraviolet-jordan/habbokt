package com.habbokt.page.me

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page
import com.habbokt.page.Template
import io.ktor.http.Parameters
import io.ktor.server.sessions.CurrentSession
import javax.inject.Qualifier

/**
 * @author Jordan Abraham
 */
class MePage @Inject constructor(
   private val siteService: SiteService
) : Page<MePageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): MePageTemplate = MePageTemplate(
        site = siteService.site()
    )
}