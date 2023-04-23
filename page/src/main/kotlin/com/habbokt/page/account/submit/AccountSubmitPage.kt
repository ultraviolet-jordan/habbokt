package com.habbokt.page.account.submit

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountSubmitPage @Inject constructor(
    private val siteService: SiteService
) : Page<AccountSubmitPageRequest>(
    name = "account/submit.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }
    }
)