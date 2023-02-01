package com.habbokt.page.client

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
class ClientPageService @Inject constructor(
    private val compiler: Compiler
) : PageService<ClientPage, ClientPageRequest, Html, None>(
    get = {
        html(it, compiler)
    }
)