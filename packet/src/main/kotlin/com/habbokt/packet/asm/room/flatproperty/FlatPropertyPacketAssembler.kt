package com.habbokt.packet.asm.room.flatproperty

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class FlatPropertyPacketAssembler : PacketAssembler<FlatPropertyPacket>(
    id = 46,
    body = {
        putStringHabbo(it.key)
        putStringHabbo(it.value)
    }
)