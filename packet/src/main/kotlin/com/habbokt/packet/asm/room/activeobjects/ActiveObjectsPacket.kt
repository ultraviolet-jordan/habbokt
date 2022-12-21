package com.habbokt.packet.asm.room.activeobjects

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class ActiveObjectsPacket(
    val objects: List<Int>
) : Packet