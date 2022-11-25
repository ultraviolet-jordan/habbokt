package com.habbokt.page.me

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    private val site: SiteDAO?
) : PageTemplate("me.tpl") {
    override fun configure() {
        bind("site" to site)
    }
}