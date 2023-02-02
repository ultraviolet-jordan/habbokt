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
) : Page<AccountPasswordForgotPageTemplate, AccountPasswordForgotPageRequest>(
    template = {
        AccountPasswordForgotPageTemplate(
            site = siteService.site()
        )
    }
)