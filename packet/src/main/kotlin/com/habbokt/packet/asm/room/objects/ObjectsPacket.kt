package com.habbokt.packet.asm.room.objects

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class ObjectsPacket(
    val objects: List<Int>
) : Packet