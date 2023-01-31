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
) : Page<IndexPageTemplate>(
    template = { _, request ->
        IndexPageTemplate(
            site = siteService.site(),
            rememberMe = request.queryParameters["rememberme"].toBoolean(),
            username = request.queryParameters["username"]
        )
    }
)