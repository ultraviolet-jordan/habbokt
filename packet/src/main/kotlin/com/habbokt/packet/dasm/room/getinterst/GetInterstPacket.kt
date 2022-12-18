package com.habbokt.packet.dasm.room.getinterst

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class GetInterstPacket(
    val parameter: String
) : Packet