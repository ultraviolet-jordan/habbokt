package com.habbokt.dao

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.players.PlayersServiceEhcache
import com.habbokt.dao.site.SiteDAO
import com.habbokt.dao.site.SiteService
import com.habbokt.dao.site.SiteServiceEhcache
import com.habbokt.db.CachingAliases
import com.habbokt.db.CachingResourcePoolBuilder
import dev.misfitlabs.kotlinguice4.KotlinModule
import org.ehcache.Cache

/**
 * @author Jordan Abraham
 */
object DAOModule : KotlinModule() {
    override fun configure() {
        // Site DAO
        bind<SiteService>().to<SiteServiceEhcache>()

        val siteResourcePool = CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.SiteTableCache, SiteDAO::class.java)
        bind<Cache<Int, SiteDAO>>().toInstance(siteResourcePool)

        // Players DAO
        bind<PlayersService>().to<PlayersServiceEhcache>()

        val playersResourcePool = CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.PlayersTableCache, PlayerDAO::class.java)
        bind<Cache<Int, PlayerDAO>>().toInstance(playersResourcePool)
    }
}