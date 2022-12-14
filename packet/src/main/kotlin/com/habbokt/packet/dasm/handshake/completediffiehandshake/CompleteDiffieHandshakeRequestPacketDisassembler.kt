package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestPacketDisassembler : PacketDisassembler(Disassembler {
    CompleteDiffieHandshakeRequestPacket(
        publicKey = it.getStringHabbo()
    )
})