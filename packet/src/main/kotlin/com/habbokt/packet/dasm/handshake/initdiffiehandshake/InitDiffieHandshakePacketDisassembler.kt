package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakePacketDisassembler : PacketDisassembler<InitDiffieHandshakeRequestPacket>(
    body = {
        InitDiffieHandshakeRequestPacket(
            value = getIntHabbo()
        )
    }
)