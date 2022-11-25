package com.habbokt.page.index

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class IndexPageTemplate(
    site: SiteDAO?,
    rememberMe: Boolean,
    username: String?
) : BaseTemplate(path = "index.tpl", site) {
    init {
        this["rememberMe"] to rememberMe
        this["username"] to username
    }
}