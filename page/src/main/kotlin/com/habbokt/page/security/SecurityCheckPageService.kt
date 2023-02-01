package com.habbokt.page.security

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
class SecurityCheckPageService @Inject constructor(
    private val compiler: Compiler
) : PageService<SecurityCheckPage, SecurityCheckPageRequest, Html, None>(
    get = {
        html(it, compiler)
    }
)