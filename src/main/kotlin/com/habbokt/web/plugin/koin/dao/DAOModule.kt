package com.habbokt.web.plugin.koin.dao

import com.habbokt.web.dao.CachingAliases
import com.habbokt.web.dao.keyedCacheResourcePool
import com.habbokt.web.dao.players.Player
import com.habbokt.web.dao.players.PlayersDAO
import com.habbokt.web.dao.players.PlayersDAODelegate
import com.habbokt.web.dao.players.PlayersDAOService
import com.habbokt.web.dao.site.Site
import com.habbokt.web.dao.site.SiteDAO
import com.habbokt.web.dao.site.SiteDAODelegate
import com.habbokt.web.dao.site.SiteDAOService
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module

/**
 * @author Jordan Abraham
 */
fun daoModule() = module(createdAtStart = true) {
    single { createSiteDAO() }
    single { createPlayersDAO() }
}

private fun createSiteDAO(): SiteDAO = SiteDAOService(
    delegate = SiteDAODelegate(),
    cache = keyedCacheResourcePool(CachingAliases.SiteTableCache, Site::class.java)
).apply {
    runBlocking {
        // TODO This is only for testing purposes for now.
        createSite("Habbo Hotel", "http://localhost")
    }
}

private fun createPlayersDAO(): PlayersDAO = PlayersDAOService(
    delegate = PlayersDAODelegate(),
    cache = keyedCacheResourcePool(CachingAliases.PlayersTableCache, Player::class.java)
)
