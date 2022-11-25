package com.habbokt.page.welcome

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class WelcomePageTemplate(
    site: SiteDAO?
) : BaseTemplate(path = "welcome.tpl", site)