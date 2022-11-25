package com.habbokt.page.security

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class SecurityCheckPageTemplate(
    site: SiteDAO?,
    redirectPath: String
) : BaseTemplate(path = "security_check.tpl", site) {
    init {
        this["redirectPath"] to redirectPath
    }
}