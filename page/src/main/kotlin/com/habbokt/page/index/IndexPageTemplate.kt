package com.habbokt.page.index

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.Template

/**
 * @author Jordan Abraham
 */
class IndexPageTemplate(
    site: SiteDAO,
    rememberMe: Boolean,
    username: String?
) : Template(path = "index.tpl", site) {
    init {
        put("rememberMe", rememberMe)
        put("username", username)
    }
}