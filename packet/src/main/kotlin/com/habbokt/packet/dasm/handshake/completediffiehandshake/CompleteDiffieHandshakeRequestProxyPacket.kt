package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeRequestProxyPacket(
    val secretKey: String
) : ProxyPacket