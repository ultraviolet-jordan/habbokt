package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestPacketDisassembler : PacketDisassembler(Disassembler(id = 2002) {
    CompleteDiffieHandshakeRequestPacket(
        publicKey = it.getStringHabbo()
    )
})