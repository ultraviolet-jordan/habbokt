package com.habbokt.packet.asm.handshake.initdiffiehandshake

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeResponsePacket(
    val securityCastToken: String,
    val serverToClient: Int
) : Packet