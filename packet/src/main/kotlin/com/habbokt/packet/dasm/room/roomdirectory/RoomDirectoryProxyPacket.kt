package com.habbokt.packet.dasm.room.roomdirectory

import com.habbokt.api.packet.ProxyPacket
import com.habbokt.dao.rooms.RoomDAO

/**
 * @author Jordan Abraham
 */
data class RoomDirectoryProxyPacket(
    val room: RoomDAO
) : ProxyPacket