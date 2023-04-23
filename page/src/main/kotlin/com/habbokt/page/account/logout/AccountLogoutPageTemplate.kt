package com.habbokt.page.account.logout

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class AccountLogoutPageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "account/logout.tpl",
    configuration = {
        site?.let { put("site", it) }
    }
)