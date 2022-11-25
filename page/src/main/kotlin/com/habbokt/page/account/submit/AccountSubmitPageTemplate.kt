package com.habbokt.page.account.submit

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class AccountSubmitPageTemplate(
    private val site: SiteDAO?
) : PageTemplate("account/submit.tpl") {
    override fun configure() {
        bind("site" to site)
    }
}