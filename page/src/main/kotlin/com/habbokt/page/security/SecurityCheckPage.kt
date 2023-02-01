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
) : Page<SecurityCheckPageTemplate, SecurityCheckPageRequest>(
    template = {
        SecurityCheckPageTemplate(
            site = siteService.site(),
            redirectPath = redirectPath
        )
    }
)