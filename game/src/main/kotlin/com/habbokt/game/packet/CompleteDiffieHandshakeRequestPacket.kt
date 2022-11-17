package com.habbokt.game.packet

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeRequestPacket(
    val publicKey: String
) : Packet