package com.habbokt.page.me

import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.BaseTemplate

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    site: SiteDAO
) : BaseTemplate(path = "me.tpl", site)