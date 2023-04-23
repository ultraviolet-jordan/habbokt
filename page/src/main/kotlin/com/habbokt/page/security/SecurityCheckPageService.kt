package com.habbokt.page.security

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
class SecurityCheckPageService @Inject constructor(
    private val page: SecurityCheckPage
) : PageService<SecurityCheckPageRequest, Html, None>(
    get = {
        page.html(this)
    }
)