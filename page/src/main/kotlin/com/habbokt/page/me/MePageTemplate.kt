package com.habbokt.page.me

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    site: SiteDAO?,
    playerDetails: PlayerDAO?
) : PageTemplate(
    path = "me.tpl",
    configuration = {
        site?.let { put("site", it) }
        playerDetails?.let { put("playerDetails", it) }
    }
)