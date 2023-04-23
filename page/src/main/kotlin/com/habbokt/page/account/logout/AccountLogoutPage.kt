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
) : Page<AccountLogoutPageRequest>(
    name = "account/logout.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }
    }
)