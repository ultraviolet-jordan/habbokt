package com.habbokt.page.me

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.site.SiteService
import com.habbokt.page.Page

/**
 * @author Jordan Abraham
 */
@Singleton
class MePage @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService
) : Page<MePageRequest>(
    name = "me.tpl",
    template = {
        siteService.site()?.let { siteDAO ->
            put("site", siteDAO)
        }

        playersService.player(it.userId)?.let { playerDAO ->
            put("playerDetails", playerDAO)
        }
    }
)