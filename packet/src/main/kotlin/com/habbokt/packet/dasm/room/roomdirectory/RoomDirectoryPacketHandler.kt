package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.flatproperty.FlatPropertyPacket
import com.habbokt.packet.asm.room.roomready.RoomReadyPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryPacketHandler : PacketHandler<RoomDirectoryProxyPacket>(
    handler = {
        writePacket(
            RoomReadyPacket(
                worldType = it.room.model,
                unitId = it.room.id
            )
        )

        writePacket(
            FlatPropertyPacket(
                key = "landscape",
                value = "0.0"
            )
        )
    }
)