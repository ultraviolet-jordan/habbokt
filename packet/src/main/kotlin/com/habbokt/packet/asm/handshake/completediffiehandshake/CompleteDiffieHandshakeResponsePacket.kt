package com.habbokt.packet.asm.handshake.completediffiehandshake

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class CompleteDiffieHandshakeResponsePacket(
    val secretKey: String
) : Packet