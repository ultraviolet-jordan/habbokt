package com.habbokt.page.welcome

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class WelcomePageTemplate(
    site: SiteDAO?
) : PageTemplate(
    path = "welcome.tpl",
    configuration = {
        bind("site" to site)
    }
)