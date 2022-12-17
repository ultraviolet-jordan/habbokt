package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.api.room.Room
import com.habbokt.dao.rooms.RoomsService
import com.habbokt.dao.rooms.categories.RoomsCategoriesService

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigateProxyPacketHandler @Inject constructor(
    private val roomsService: RoomsService,
    private val roomsCategoriesService: RoomsCategoriesService
) : ProxyPacketHandler<NavigatePacket>(ProxyHandler {
    val category = roomsCategoriesService.roomCategory(id) ?: return@ProxyHandler null
    val rooms = roomsService.roomsByCategoryId(category.id)

    return@ProxyHandler NavigateProxyPacket(
        hideFullRooms = mask == 1,
        category = category,
        rooms = rooms.map { room ->
            Room(
                port = room.id + 1000,
                type = 1,
                name = room.name,
                userCount = 4,
                maxUsers = 50,
                parentId = room.categoryId,
                description = "test",
                door = 0, // No password
                swfCast = "",
                usersInQueue = 0,
                visible = true
            )
        }
    )
})