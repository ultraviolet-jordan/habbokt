package com.habbokt.page.account.password.forgot

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountPasswordForgotPage @Inject constructor(
    private val siteService: SiteService
) : Page<AccountPasswordForgotPageRequest>(
    name = "account/email/account_forgot.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }
    }
)