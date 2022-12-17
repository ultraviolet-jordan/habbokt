package com.habbokt.dao

import com.habbokt.dao.players.PlayerDAO
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.players.PlayersServiceEhcache
import com.habbokt.dao.rooms.RoomDAO
import com.habbokt.dao.rooms.RoomsService
import com.habbokt.dao.rooms.RoomsServiceEhcache
import com.habbokt.dao.rooms.categories.RoomCategoryDAO
import com.habbokt.dao.rooms.categories.RoomsCategoriesService
import com.habbokt.dao.rooms.categories.RoomsCategoriesServiceEhcache
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
        bind<Cache<Int, SiteDAO>>().toInstance(CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.SiteTableCache, SiteDAO::class.java))

        // Players DAO
        bind<PlayersService>().to<PlayersServiceEhcache>()
        bind<Cache<Int, PlayerDAO>>().toInstance(CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.PlayersTableCache, PlayerDAO::class.java))

        // Rooms DAO
        bind<RoomsService>().to<RoomsServiceEhcache>()
        bind<Cache<Int, RoomDAO>>().toInstance(CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.RoomsTableCache, RoomDAO::class.java))

        // Rooms Categories DAO
        bind<RoomsCategoriesService>().to<RoomsCategoriesServiceEhcache>()
        bind<Cache<Int, RoomCategoryDAO>>().toInstance(CachingResourcePoolBuilder.buildCachingResourcePool(CachingAliases.RoomsCategoriesTableCache, RoomCategoryDAO::class.java))
    }
}