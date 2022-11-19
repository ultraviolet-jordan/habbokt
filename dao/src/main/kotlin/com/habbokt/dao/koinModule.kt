package com.habbokt.dao

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.players.PlayersServiceDelegate
import com.habbokt.dao.players.PlayersServiceEhcache
import com.habbokt.dao.site.SiteDAO
import com.habbokt.dao.site.SiteService
import com.habbokt.dao.site.SiteServiceDelegate
import com.habbokt.dao.site.SiteServiceEhcache
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
val DAOModule = module(createdAtStart = true) {
    single { createSiteService() }
    single { createPlayersService() }
}

private fun createSiteService(): SiteService = SiteServiceEhcache(
    delegate = SiteServiceDelegate(),
    cache = keyedCacheResourcePool(CachingAliases.SiteTableCache, SiteDAO::class.java)
)

private fun createPlayersService(): PlayersService = PlayersServiceEhcache(
    delegate = PlayersServiceDelegate(),
    cache = keyedCacheResourcePool(CachingAliases.PlayersTableCache, PlayerDAO::class.java)
)
