package com.habbokt.page.welcome

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class WelcomePage @Inject constructor(
    private val siteService: SiteService
) : Page<WelcomePageTemplate, WelcomePageRequest>(
    template = {
        WelcomePageTemplate(
            site = siteService.site()
        )
    }
)