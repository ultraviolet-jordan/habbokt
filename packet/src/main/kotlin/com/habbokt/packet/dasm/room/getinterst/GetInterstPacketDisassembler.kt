package com.habbokt.packet.dasm.room.getinterst

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getString

/**
 * @author Jordan Abraham
 */
@Singleton
class GetInterstPacketDisassembler : PacketDisassembler<GetInterstPacket>(
    body = {
        GetInterstPacket(
            parameter = getString(length = remaining.toInt()) // This packet reads a raw string from the buffer.
        )
    }
)