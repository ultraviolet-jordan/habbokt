package com.habbokt.page.me

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    site: SiteDAO?
) : PageTemplate(path = "me.tpl", site)