package com.habbokt.packet.dasm.room.roomdirectory

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class RoomDirectoryProxyPacket(
    val typeId: Int,
    val roomId: Int,
    val doorId: Int
) : ProxyPacket