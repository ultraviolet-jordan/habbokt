package com.habbokt.game.packet

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeResponsePacket(
    val securityCastToken: String,
    val serverToClient: Int
) : Packet