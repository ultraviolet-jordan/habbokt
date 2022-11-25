package com.habbokt.page.welcome

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class WelcomePageTemplate(
    site: SiteDAO?
) : PageTemplate(path = "welcome.tpl", site)