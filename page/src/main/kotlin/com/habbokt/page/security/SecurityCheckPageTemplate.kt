package com.habbokt.page.security

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class SecurityCheckPageTemplate(
    site: SiteDAO?,
    redirectPath: String
) : PageTemplate(
    path = "security_check.tpl",
    configuration = {
        bind("site" to site)
        bind("redirectPath" to redirectPath)
    }
)