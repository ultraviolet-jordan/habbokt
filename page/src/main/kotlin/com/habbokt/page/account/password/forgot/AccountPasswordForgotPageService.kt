package com.habbokt.page.account.password.forgot

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Html
import com.habbokt.page.None
import com.habbokt.page.PageService
import com.habbokt.page.html
import com.habbokt.templating.Compiler

/**
 * @author Jordan Abraham
 */
@Singleton
class AccountPasswordForgotPageService @Inject constructor(
    private val compiler: Compiler,
    private val page: AccountPasswordForgotPage
) : PageService<AccountPasswordForgotPageRequest, Html, None>(
    get = {
        html(page, compiler)
    }
)