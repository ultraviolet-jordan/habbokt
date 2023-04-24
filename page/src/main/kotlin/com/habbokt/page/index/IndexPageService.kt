package com.habbokt.page.index

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.Html
import com.habbokt.page.None
import com.habbokt.page.PageService
import com.habbokt.page.html

/**
 * @author Jordan Abraham
 *
 * @see IndexPage
 * @see IndexPageRequest
 * @see IndexPageRouting
 *
 * @constructor Injects the [page] that is used for this service.
 *
 * @property get The service handling for http GET requests to this [page].
 */
@Singleton
class IndexPageService @Inject constructor(
    private val page: IndexPage
) : PageService<IndexPageRequest, Html, None>(
    get = {
        page.html(this)
    }
)