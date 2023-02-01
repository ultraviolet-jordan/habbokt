package com.habbokt.page.index

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
class IndexPageService @Inject constructor(
    private val compiler: Compiler
) : PageService<IndexPage, IndexPageRequest, Html, None>(
    get = {
        html(it, compiler)
    }
)