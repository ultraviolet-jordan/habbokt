package com.habbokt.page.me

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage

/**
 * @author Jordan Abraham
 */
@Singleton
class MePageService : PageService<MePage>(
    get = {
        respondHtmlPage(it)
    }
)