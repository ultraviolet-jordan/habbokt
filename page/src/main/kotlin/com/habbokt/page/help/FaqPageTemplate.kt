package com.habbokt.page.help

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate
import com.habbokt.page.bind

/**
 * @author Jordan Abraham
 */
class FaqPageTemplate(
    site: SiteDAO?,
    playerDetails: PlayerDAO?
) : PageTemplate(
    path = "faq.tpl",
    configuration = {
        bind("site" to site)
        bind("playerDetails" to playerDetails)
    }
)