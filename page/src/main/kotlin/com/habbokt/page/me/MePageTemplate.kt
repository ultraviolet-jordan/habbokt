package com.habbokt.page.me

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.Template

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    site: SiteDAO
) : Template(path = "me.tpl", site)