package com.habbokt.packet.asm.room.heightmap

import com.habbokt.api.map.HeightMap
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class HeightMapPacket(
    val heightMap: HeightMap
) : Packet