package com.habbokt.page.security

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class SecurityCheckPageTemplate(
    site: SiteDAO?,
    redirectPath: String
) : PageTemplate("security_check.tpl") {
    init {
        this["site"] to site
        this["redirectPath"] to redirectPath
    }
}