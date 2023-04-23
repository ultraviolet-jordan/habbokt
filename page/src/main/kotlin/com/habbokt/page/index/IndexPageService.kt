package com.habbokt.page.index

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
class IndexPageService @Inject constructor(
    private val page: IndexPage
) : PageService<IndexPageRequest, Html, None>(
    get = {
        page.html(this)
    }
)