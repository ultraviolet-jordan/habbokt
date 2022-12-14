package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class ScrGetUserInfoPacket(
    val productName: String
) : Packet