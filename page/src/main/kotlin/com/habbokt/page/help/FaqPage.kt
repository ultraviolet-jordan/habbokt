package com.habbokt.page.help

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class FaqPage @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService
) : Page<FaqPageRequest>(
    name = "faq.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }

        it.userId
            ?.let { userId -> playersService.player(userId) }
            ?.let { playerDAO ->
                put("playerDetails", playerDAO)
            }
    }
)