package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.rooms.categories.RoomsCategoriesService

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigateProxyPacketHandler @Inject constructor(
    private val roomsCategoriesService: RoomsCategoriesService
) : ProxyPacketHandler<NavigatePacket>(ProxyHandler {
    val hide = mask == 1
    val roomCategory = roomsCategoriesService.roomCategory(id)
    println(roomCategory)
    return@ProxyHandler NavigateProxyPacket()
})