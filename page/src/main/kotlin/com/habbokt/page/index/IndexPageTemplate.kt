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
) : PageTemplate("index.tpl") {
    init {
        this["site"] to site
        this["rememberMe"] to rememberMe
        this["username"] to username
    }
}