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
) : Page<WelcomePageRequest>(
    name = "welcome.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }
    }
)