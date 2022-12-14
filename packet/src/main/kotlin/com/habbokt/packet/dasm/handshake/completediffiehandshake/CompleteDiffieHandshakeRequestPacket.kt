package com.habbokt.packet.dasm.handshake.completediffiehandshake

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeRequestPacket(
    val publicKey: String
) : Packet