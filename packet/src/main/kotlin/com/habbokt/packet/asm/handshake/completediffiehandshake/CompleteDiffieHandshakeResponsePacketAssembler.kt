package com.habbokt.packet.asm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeResponsePacketAssembler : PacketAssembler<CompleteDiffieHandshakeResponsePacket>(
    id = 1,
    body = {
        putStringHabbo(it.secretKey)
    }
)