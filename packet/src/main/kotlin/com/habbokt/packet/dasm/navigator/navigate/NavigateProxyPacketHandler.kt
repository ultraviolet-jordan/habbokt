package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Inject
import com.google.inject.Singleton
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
) : ProxyPacketHandler<NavigatePacket, NavigateProxyPacket>(
    handler = {
        roomsCategoriesService.roomCategory(it.id)?.let { category ->
            val subCategories = roomsCategoriesService.subCategories(category.id)
            val rooms = roomsService.roomsByCategoryId(category.id)
            NavigateProxyPacket(it.mask == 1, category, subCategories, rooms)
        }
    }
)