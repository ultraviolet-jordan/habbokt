package com.habbokt.game.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeResponsePacket(
    val securityCastToken: String,
    val serverToClient: Int
) : Packet