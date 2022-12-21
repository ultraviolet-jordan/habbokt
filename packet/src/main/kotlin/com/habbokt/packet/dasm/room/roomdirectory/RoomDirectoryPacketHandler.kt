package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.flatproperty.FlatPropertyPacket
import com.habbokt.packet.asm.room.roomready.RoomReadyPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryPacketHandler : PacketHandler<RoomDirectoryProxyPacket>(Handler {
    it.writePacket(RoomReadyPacket(
        worldType = room.model,
        unitId = room.id
    ))

    it.writePacket(FlatPropertyPacket(
        key = "landscape",
        value = "0.0"
    ))
})