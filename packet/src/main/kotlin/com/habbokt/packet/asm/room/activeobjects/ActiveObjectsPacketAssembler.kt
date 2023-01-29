package com.habbokt.packet.asm.room.activeobjects

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ActiveObjectsPacketAssembler : PacketAssembler<ActiveObjectsPacket>(
    id = 32,
    body = {
        putIntHabbo(it.objects.size)
    }
)