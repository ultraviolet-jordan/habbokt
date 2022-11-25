package com.habbokt.page.index

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class IndexPageTemplate(
    private val site: SiteDAO?,
    private val rememberMe: Boolean,
    private val username: String?
) : PageTemplate("index.tpl") {
    override fun configure() {
        bind("site" to site)
        bind("rememberMe" to rememberMe)
        bind("username" to username)
    }
}