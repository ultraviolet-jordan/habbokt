package com.habbokt.dao

import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.players.PlayersServiceDelegate
import com.habbokt.dao.rooms.RoomsService
import com.habbokt.dao.rooms.RoomsServiceDelegate
import com.habbokt.dao.rooms.categories.RoomsCategoriesService
import com.habbokt.dao.rooms.categories.RoomsCategoriesServiceDelegate
import com.habbokt.dao.site.SiteService
import com.habbokt.dao.site.SiteServiceDelegate
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
object DAOModule : KotlinModule() {
    override fun configure() {
        bind<SiteService>().to<SiteServiceDelegate>()
        bind<PlayersService>().to<PlayersServiceDelegate>()
        bind<RoomsService>().to<RoomsServiceDelegate>()
        bind<RoomsCategoriesService>().to<RoomsCategoriesServiceDelegate>()
    }
}