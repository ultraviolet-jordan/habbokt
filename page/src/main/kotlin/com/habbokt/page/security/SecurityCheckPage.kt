package com.habbokt.page.security

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class SecurityCheckPage @Inject constructor(
    private val siteService: SiteService
) : Page<SecurityCheckPageTemplate>(
    template = { _, _ ->
        SecurityCheckPageTemplate(
            site = siteService.site(),
            redirectPath = "/me" // TODO or /welcome
        )
    }
)