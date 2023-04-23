package com.habbokt.page.help

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class FaqPageTemplate(
    site: SiteDAO?,
    playerDetails: PlayerDAO?
) : PageTemplate(
    path = "faq.tpl",
    configuration = {
        site?.let { put("site", it) }
        playerDetails?.let { put("playerDetails", it) }
    }
)