package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryProxyPacketHandler : ProxyPacketHandler<RoomDirectoryPacket>(ProxyHandler {
    return@ProxyHandler RoomDirectoryProxyPacket(typeId, roomId, doorId)
})