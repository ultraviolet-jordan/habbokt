package com.habbokt.page.me

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    site: SiteDAO?,
    playerDetails: PlayerDAO?
) : PageTemplate(
    path = "me.tpl",
    configuration = {
        bind("site" to site)
        bind("playerDetails" to playerDetails)
    }
)