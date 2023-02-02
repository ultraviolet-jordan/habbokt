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
) : Page<FaqPageTemplate, FaqPageRequest>(
    template = {
        FaqPageTemplate(
            site = siteService.site(),
            playerDetails = userId?.let { playersService.player(it) }
        )
    }
)