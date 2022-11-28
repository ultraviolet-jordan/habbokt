package com.habbokt.page.security

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class SecurityCheckPageTemplate(
    private val site: SiteDAO?,
    private val redirectPath: String
) : PageTemplate(path = "security_check.tpl") {
    override fun configure() {
        bind("site" to site)
        bind("redirectPath" to redirectPath)
    }
}