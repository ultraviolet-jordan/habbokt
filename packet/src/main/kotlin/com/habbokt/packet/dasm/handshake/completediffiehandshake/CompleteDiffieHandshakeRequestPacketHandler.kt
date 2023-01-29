package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.completediffiehandshake.CompleteDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestPacketHandler : PacketHandler<CompleteDiffieHandshakeRequestProxyPacket>(
    handler = {
        writePacket(
            CompleteDiffieHandshakeResponsePacket(
                secretKey = it.secretKey
            )
        )
    }
)