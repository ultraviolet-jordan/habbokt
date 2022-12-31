package com.habbokt.packet.asm.room.heightmap

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putString

/**
 * @author Jordan Abraham
 */
@Singleton
class HeightMapPacketAssembler : PacketAssembler<HeightMapPacket>(Assembler(id = 31) {
    heightMap.rows.forEach(it::putString)
})