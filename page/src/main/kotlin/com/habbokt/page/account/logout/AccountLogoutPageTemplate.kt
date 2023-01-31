package com.habbokt.page.account.logout

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class AccountLogoutPageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "account/logout.tpl",
    configuration = {
        bind("site" to site)
    }
)