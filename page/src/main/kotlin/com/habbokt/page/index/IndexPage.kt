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
) : Page<IndexPageRequest>(
    name = "index.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }

        put("rememberMe", it.rememberMe)

        it.username?.let { username ->
            put("username", username)
        }
    }
)