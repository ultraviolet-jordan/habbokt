package com.habbokt.page.welcome

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class WelcomePageTemplate(
    private val site: SiteDAO?
) : PageTemplate("welcome.tpl") {
    override fun configure() {
        bind("site" to site)
    }
}