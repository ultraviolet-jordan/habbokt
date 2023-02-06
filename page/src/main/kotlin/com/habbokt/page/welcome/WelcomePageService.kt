package com.habbokt.page.welcome

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
class WelcomePageService @Inject constructor(
    private val compiler: Compiler,
    private val page: WelcomePage
) : PageService<WelcomePageRequest, Html, None>(
    get = {
        page.html(this, compiler)
    }
)