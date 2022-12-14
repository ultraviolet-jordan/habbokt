package com.habbokt.packet.dasm.handshake.initdiffiehandshake

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InitDiffieHandshakeRequestPacket(
    val value: Int
) : Packet