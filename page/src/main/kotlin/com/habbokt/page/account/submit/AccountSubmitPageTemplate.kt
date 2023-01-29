package com.habbokt.page.account.submit

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class AccountSubmitPageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "account/submit.tpl",
    configuration = {
        bind("site" to site)
    }
)