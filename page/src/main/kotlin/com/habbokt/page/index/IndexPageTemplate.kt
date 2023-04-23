package com.habbokt.page.index

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

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
        site?.let { put("site", it) }
        put("rememberMe", rememberMe)
        username?.let { put("username", it) }
    }
)