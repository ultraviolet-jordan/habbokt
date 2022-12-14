package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.completediffiehandshake.CompleteDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
@Singleton
class CompleteDiffieHandshakeRequestPacketHandler : PacketHandler<CompleteDiffieHandshakeRequestProxyPacket>(Handler {
    it.writePacket(CompleteDiffieHandshakeResponsePacket(secretKey))
})