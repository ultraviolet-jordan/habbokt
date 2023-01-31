package com.habbokt.page.security

import com.google.inject.Singleton
import com.habbokt.page.PageService
import com.habbokt.page.respondHtmlPage

/**
 * @author Jordan Abraham
 */
@Singleton
class SecurityCheckPageService : PageService<SecurityCheckPage>(
    get = {
        respondHtmlPage(it)
    }
)