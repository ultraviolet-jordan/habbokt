package com.habbokt.page.account.password.forgot

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class AccountPasswordForgotPageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "account/email/account_forgot.tpl",
    configuration = {
        site?.let { put("site", it) }
    }
)