package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.rooms.RoomsService

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryProxyPacketHandler @Inject constructor(
    private val roomsService: RoomsService
) : ProxyPacketHandler<RoomDirectoryPacket>(ProxyHandler {
    val room = roomsService.room(roomId) ?: return@ProxyHandler null
    return@ProxyHandler RoomDirectoryProxyPacket(room)
})