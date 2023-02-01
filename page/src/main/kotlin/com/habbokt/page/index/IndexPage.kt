package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class IndexPage @Inject constructor(
    private val siteService: SiteService
) : Page<IndexPageTemplate, IndexPageRequest>(
    template = {
        IndexPageTemplate(
            site = siteService.site(),
            rememberMe = rememberMe,
            username = username
        )
    }
)