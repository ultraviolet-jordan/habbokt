package com.habbokt.packet.dasm.room.roomdirectory

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomDirectoryPacketDisassembler : PacketDisassembler(Disassembler {
    RoomDirectoryPacket(
        typeId = it.getIntHabbo(),
        roomId = it.getIntHabbo(),
        doorId = it.getIntHabbo()
    )
})