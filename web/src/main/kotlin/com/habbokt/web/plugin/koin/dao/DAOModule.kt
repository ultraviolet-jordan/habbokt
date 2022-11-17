package com.habbokt.web.plugin.koin.dao

import com.habbokt.dao.CachingAliases
import com.habbokt.dao.keyedCacheResourcePool
import com.habbokt.dao.players.Player
import com.habbokt.dao.players.PlayersDAO
import com.habbokt.dao.players.PlayersDAODelegate
import com.habbokt.dao.players.PlayersDAOService
import com.habbokt.dao.site.Site
import com.habbokt.dao.site.SiteDAO
import com.habbokt.dao.site.SiteDAODelegate
import com.habbokt.dao.site.SiteDAOService
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
        createSite(
            siteName = "Habbo Hotel",
            sitePath = "http://localhost",
            staticContentPath = "http://localhost",
            serverOnline = true,
            loaderGameIp = "127.0.0.1",
            loaderGamePort = 43594,
            loaderDcr = "http://localhost/dcr/v31/habbo.dcr?",
            loaderVariables = "http://localhost/dcr/v31/gamedata/external_variables.txt?",
            loaderTexts = "http://localhost/dcr/v31/gamedata/external_texts.txt?"
        )
    }
}

private fun createPlayersDAO(): PlayersDAO = PlayersDAOService(
    delegate = PlayersDAODelegate(),
    cache = keyedCacheResourcePool(CachingAliases.PlayersTableCache, Player::class.java)
).apply {
    runBlocking {
        // TODO This is only for testing purposes for now.
        createPlayer(
            username = "jordan",
            password = "\$argon2i\$v=19\$m=65536,t=12,p=1\$hk7pQ0uj76PrcB9I+Jc4CQ\$P68lqFBz6xGKACjmdbIuPn0voRyX4shoeTdvNraSLYQ", // "password1"
            email = "test@gmail.com",
            appearance = "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-",
            gender = "F"
        )
    }
}
