package com.habbokt.page.account.password.forgot

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Html
import com.habbokt.page.None
import com.habbokt.page.PageService
import com.habbokt.page.html

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountPasswordForgotPageService @Inject constructor(
    private val page: AccountPasswordForgotPage
) : PageService<AccountPasswordForgotPageRequest, Html, None>(
    get = {
        page.html(this)
    }
)