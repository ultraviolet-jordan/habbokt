package com.habbokt.page.welcome

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage

/**
 * @author Jordan Abraham
 */
@Singleton
class WelcomePageService : PageService<WelcomePage>(
    get = {
        respondHtmlPage(it)
    }
)