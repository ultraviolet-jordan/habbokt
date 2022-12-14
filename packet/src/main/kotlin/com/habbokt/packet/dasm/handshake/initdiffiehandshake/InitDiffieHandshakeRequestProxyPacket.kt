package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeRequestProxyPacket(
    val securityCastToken: String,
    val serverToClient: Int
) : ProxyPacket