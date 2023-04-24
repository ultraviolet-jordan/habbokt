package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 *
 * @see IndexPageRequest
 * @see IndexPageRouting
 * @see IndexPageService
 *
 * @constructor Injects the [siteService] for pulling the latest website information from the database for this page [template].
 *
 * @property name The resources name of the associated page template file.
 * @property template The template builder for building the html of this page.
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