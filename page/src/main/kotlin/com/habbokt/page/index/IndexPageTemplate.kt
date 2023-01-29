package com.habbokt.page.index

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class IndexPageTemplate(
    site: SiteDAO?,
    rememberMe: Boolean,
    username: String?
) : PageTemplate(
    path = "index.tpl",
    configuration = {
        bind("site" to site)
        bind("rememberMe" to rememberMe)
        bind("username" to username)
    }
)