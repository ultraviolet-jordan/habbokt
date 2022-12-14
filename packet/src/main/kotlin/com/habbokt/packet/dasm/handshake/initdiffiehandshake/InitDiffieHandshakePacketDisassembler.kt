package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakePacketDisassembler : PacketDisassembler(Disassembler {
    InitDiffieHandshakeRequestPacket(
        value = it.getIntHabbo()
    )
})