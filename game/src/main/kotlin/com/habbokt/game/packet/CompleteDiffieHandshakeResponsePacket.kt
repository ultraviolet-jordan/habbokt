package com.habbokt.game.packet

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeResponsePacket(
    val secretKey: String
) : Packet