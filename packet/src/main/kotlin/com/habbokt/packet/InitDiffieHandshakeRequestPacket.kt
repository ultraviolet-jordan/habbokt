package com.habbokt.packet

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeRequestPacket(
    val value: Int
) : Packet