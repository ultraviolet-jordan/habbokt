package com.habbokt.page.account.submit

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
class AccountSubmitPage @Inject constructor(
    private val siteService: SiteService
) : Page<AccountSubmitPageTemplate> {
    override suspend fun template(sessions: CurrentSession, parameters: Parameters): Template<AccountSubmitPageTemplate> = Template {
        AccountSubmitPageTemplate(
            site = siteService.site()
        )
    }
}