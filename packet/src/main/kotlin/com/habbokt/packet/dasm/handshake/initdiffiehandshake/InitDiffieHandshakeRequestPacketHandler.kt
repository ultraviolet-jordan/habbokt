package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.initdiffiehandshake.InitDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
@Singleton
class InitDiffieHandshakeRequestPacketHandler : PacketHandler<InitDiffieHandshakeRequestProxyPacket>(
    handler = {
        writePacket(
            InitDiffieHandshakeResponsePacket(
                securityCastToken = it.securityCastToken,
                serverToClient = it.serverToClient
            )
        )
    }
)