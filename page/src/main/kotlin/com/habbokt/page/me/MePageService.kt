package com.habbokt.page.me

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
class MePageService @Inject constructor(
    private val page: MePage
) : PageService<MePageRequest, Html, None>(
    get = {
        page.html(this)
    }
)