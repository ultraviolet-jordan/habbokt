package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeRequestPacket(
    val publicKey: String
) : Packet