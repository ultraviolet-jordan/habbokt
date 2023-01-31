package com.habbokt.page.account.logout

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountLogoutPage @Inject constructor(
    private val siteService: SiteService
) : Page<AccountLogoutPageTemplate>(
    template = { _, _ ->
        AccountLogoutPageTemplate(
            site = siteService.site()
        )
    }
)