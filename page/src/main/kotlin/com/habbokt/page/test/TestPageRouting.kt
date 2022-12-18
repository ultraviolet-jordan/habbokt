package com.habbokt.page.test

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
import com.habbokt.dao.rooms.RoomsService
import com.habbokt.dao.rooms.categories.RoomsCategoriesService
import com.habbokt.dao.site.SiteDAO
import com.habbokt.dao.site.SiteService
import com.habbokt.page.PageRouting
import com.habbokt.page.Route
import io.ktor.server.application.call
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get

/**
 * @author Jordan Abraham
 */
@Singleton
class TestPageRouting @Inject constructor(
    private val siteService: SiteService,
    private val playersService: PlayersService,
    private val roomsService: RoomsService,
    private val roomsCategoriesService: RoomsCategoriesService
) : PageRouting(Route {
    get("/test") {
        suspend fun createSite() {
            siteService.createSite(
                SiteDAO(
                    siteName = "Habbo Hotel",
                    sitePath = "http://localhost",
                    staticContentPath = "http://localhost",
                    serverOnline = true,
                    loaderGameIp = "127.0.0.1",
                    loaderGamePort = 43594,
                    loaderDcr = "http://localhost/dcr/v31/habbo.dcr?",
                    loaderVariables = "http://localhost/dcr/v31/gamedata/external_variables.txt?",
                    loaderTexts = "http://localhost/dcr/v31/gamedata/external_texts.txt?",
                    habboImagingPath = "http://localhost"
                )
            )
        }

        suspend fun createPlayer() {
            playersService.createPlayer(
                name = "jordan",
                password = "\$argon2i\$v=19\$m=65536,t=12,p=1\$hk7pQ0uj76PrcB9I+Jc4CQ\$P68lqFBz6xGKACjmdbIuPn0voRyX4shoeTdvNraSLYQ", // password1
                email = "test@gmail.com",
                figure = "hr-540-38.hd-627-9.ch-645-74.lg-696-81.sh-725-74.ha-1004-1315.wa-2006-",
                sex = "F",
                ssoTicket = "",
                motto = "Hello Tyler this is my motto!"
            )
        }

        suspend fun createRooms() {
            roomsService.createRoom(
                categoryId = 3,
                name = "Welcome Lounge",
                description = "welcome_lounge",
                swfCast = "hh_room_nlobby"
            )
            roomsService.createRoom(
                categoryId = 3,
                name = "The Park",
                description = "park",
                swfCast = "hh_room_park"
            )
            roomsService.createRoom(
                categoryId = 5,
                name = "Theatredome",
                description = "theatredrome",
                swfCast = "hh_room_theater"
            )
            roomsService.createRoom(
                categoryId = 5,
                name = "Library",
                description = "library",
                swfCast = "hh_room_library"
            )
            roomsService.createRoom(
                categoryId = 6,
                name = "Habbo Kitchen",
                description = "hotel_kitchen",
                swfCast = "hh_room_kitchen"
            )
            roomsService.createRoom(
                categoryId = 6,
                name = "The Dirty Duck Pub",
                description = "the_dirty_duck_pub",
                swfCast = "hh_room_pub"
            )
            roomsService.createRoom(
                categoryId = 4,
                name = "Jordan's Room",
                description = "Hello this is my test room description!",
                swfCast = "" // Guest rooms do not have a swfCast.
            )
        }

        suspend fun createRoomCategories() {
            roomsCategoriesService.createRoomCategory(
                id = 2,
                parentId = 0,
                name = "No Category"
            )
            roomsCategoriesService.createRoomCategory(
                id = 3,
                parentId = 0,
                name = "Public Rooms"
            )
            roomsCategoriesService.createRoomCategory(
                id = 4,
                parentId = 0,
                name = "Guest Rooms"
            )
            roomsCategoriesService.createRoomCategory(
                id = 5,
                parentId = 3,
                name = "Entertainment"
            )
            roomsCategoriesService.createRoomCategory(
                id = 6,
                parentId = 3,
                name = "Restaurants and Cafes"
            )
        }

        createSite() // Create Test Site Data
        createPlayer() // Create Test Player Data
        createRooms() // Create Test Rooms Data
        createRoomCategories() // Create Test Room Categories Data
        call.respondRedirect("/")
    }
})