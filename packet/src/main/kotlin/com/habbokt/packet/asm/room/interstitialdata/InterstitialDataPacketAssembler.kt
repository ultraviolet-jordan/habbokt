package com.habbokt.packet.asm.room.interstitialdata

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InterstitialDataPacketAssembler : PacketAssembler<InterstitialDataPacket>(Assembler(id = 258) {
    it.putStringHabbo(sourceUrl)
    it.putStringHabbo(targetUrl)
})