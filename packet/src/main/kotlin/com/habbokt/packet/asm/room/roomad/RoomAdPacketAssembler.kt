package com.habbokt.packet.asm.room.roomad

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomAdPacketAssembler : PacketAssembler<RoomAdPacket>(
    id = 208,
    body = {
        putStringHabbo(it.sourceUrl)
        if (it.sourceUrl.isNotEmpty()) {
            putStringHabbo(it.targetUrl)
        }
    }
)