package com.habbokt.page.account.submit

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class AccountSubmitPageTemplate(
    site: SiteDAO?
) : PageTemplate(path = "account/submit.tpl") {
    init {
        this["site"] to site
    }
}