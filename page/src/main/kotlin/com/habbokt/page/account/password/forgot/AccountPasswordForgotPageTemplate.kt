package com.habbokt.page.account.password.forgot

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class AccountPasswordForgotPageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "account/email/account_forgot.tpl",
    configuration = {
        bind("site" to site)
    }
)