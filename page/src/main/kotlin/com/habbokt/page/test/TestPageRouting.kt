package com.habbokt.page.test

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.dao.players.PlayersService
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

        suspend fun createRoomCategories() {
            roomsCategoriesService.createRoomCategory(
                roomId = 2,
                parentRoomId = 0,
                name = "No Category"
            )
            roomsCategoriesService.createRoomCategory(
                roomId = 3,
                parentRoomId = 0,
                name = "Public Rooms"
            )
            roomsCategoriesService.createRoomCategory(
                roomId = 4,
                parentRoomId = 0,
                name = "Guest Rooms"
            )
            roomsCategoriesService.createRoomCategory(
                roomId = 5,
                parentRoomId = 3,
                name = "Entertainment"
            )
            roomsCategoriesService.createRoomCategory(
                roomId = 6,
                parentRoomId = 3,
                name = "Restaurants and Cafes"
            )
        }

        createSite() // Create Test Site Data
        createPlayer() // Create Test Player Data
        createRoomCategories() // Create Test Room Categories
        call.respondRedirect("/")
    }
})