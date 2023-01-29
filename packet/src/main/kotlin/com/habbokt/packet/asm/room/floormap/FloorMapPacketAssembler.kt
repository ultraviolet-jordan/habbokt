package com.habbokt.packet.asm.room.floormap

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putString

/**
 * @author Jordan Abraham
 */
@Singleton
class FloorMapPacketAssembler : PacketAssembler<FloorMapPacket>(
    id = 470,
    body = {
        it.heightMap.rows.forEach(::putString)
    }
)