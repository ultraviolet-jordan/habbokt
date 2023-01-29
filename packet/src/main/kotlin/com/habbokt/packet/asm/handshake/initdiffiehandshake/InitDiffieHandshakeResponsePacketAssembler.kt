package com.habbokt.packet.asm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeResponsePacketAssembler : PacketAssembler<InitDiffieHandshakeResponsePacket>(
    id = 277,
    body = {
        putStringHabbo(it.securityCastToken)
        putIntHabbo(it.serverToClient)
    }
)