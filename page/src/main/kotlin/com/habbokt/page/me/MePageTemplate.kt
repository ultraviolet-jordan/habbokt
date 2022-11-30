package com.habbokt.page.me

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.site.SiteDAO
import com.habbokt.page.PageTemplate

/**
 * @author Jordan Abraham
 */
class MePageTemplate(
    private val site: SiteDAO?,
    private val playerDetails: PlayerDAO?
) : PageTemplate(path = "me.tpl") {
    override fun configure() {
        bind("site" to site)
        bind("playerDetails" to playerDetails)
    }
}