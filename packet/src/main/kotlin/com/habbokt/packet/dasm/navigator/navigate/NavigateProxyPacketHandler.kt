package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
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
    val hideFullRooms = mask == 1
    val category = roomsCategoriesService.roomCategory(id) ?: return@ProxyHandler null
    val rooms = roomsService.roomsByCategoryId(category.id)
    return@ProxyHandler NavigateProxyPacket()
})