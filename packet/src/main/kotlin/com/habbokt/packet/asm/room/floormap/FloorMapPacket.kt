package com.habbokt.packet.asm.room.floormap

import com.habbokt.api.map.HeightMap
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class FloorMapPacket(
    val heightMap: HeightMap
) : Packet