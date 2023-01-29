package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryPacketDisassembler : PacketDisassembler<RoomDirectoryPacket>(
    body = {
        RoomDirectoryPacket(
            typeId = getIntHabbo(),
            roomId = getIntHabbo(),
            doorId = getIntHabbo()
        )
    }
)