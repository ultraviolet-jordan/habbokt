package com.habbokt.page.client

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage

/**
 * @author Jordan Abraham
 */
@Singleton
class ClientPageService : PageService<ClientPage>(
    get = {
        respondHtmlPage(it)
    }
)