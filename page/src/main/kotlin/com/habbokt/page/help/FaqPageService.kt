package com.habbokt.page.help

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
class FaqPageService @Inject constructor(
    private val compiler: Compiler,
    private val page: FaqPage
) : PageService<FaqPageRequest, Html, None>(
    get = {
        html(page, compiler)
    }
)