package com.habbokt.packet.dasm.room.getinterst

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getString

/**
 * @author Jordan Abraham
 */
@Singleton
class GetInterstPacketDisassembler : PacketDisassembler(Disassembler {
    GetInterstPacket(
        parameter = it.getString(length = it.remaining.toInt()) // This packet reads a raw string from the buffer.
    )
})