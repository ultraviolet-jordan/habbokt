package com.habbokt.packet.asm.room.roomad

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class RoomAdPacketAssembler : PacketAssembler<RoomAdPacket>(Assembler(id = 208) {
    it.putStringHabbo(sourceUrl)
    if (sourceUrl.isNotEmpty()) {
        require(sourceUrl.isNotEmpty())
        it.putStringHabbo(targetUrl)
    }
})