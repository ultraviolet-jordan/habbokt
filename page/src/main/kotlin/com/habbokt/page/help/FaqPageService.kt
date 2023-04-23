package com.habbokt.page.help

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
class FaqPageService @Inject constructor(
    private val page: FaqPage
) : PageService<FaqPageRequest, Html, None>(
    get = {
        page.html(this)
    }
)