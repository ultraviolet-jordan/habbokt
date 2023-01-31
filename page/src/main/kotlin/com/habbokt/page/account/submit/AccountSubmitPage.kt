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
) : Page<AccountSubmitPageTemplate>(
    template = { _, _ ->
        AccountSubmitPageTemplate(
            site = siteService.site()
        )
    }
)