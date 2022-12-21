package com.habbokt.packet.asm.room.flatproperty

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class FlatPropertyPacket(
    val key: String,
    val value: String
) : Packet