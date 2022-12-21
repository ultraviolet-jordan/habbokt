package com.habbokt.packet.asm.room.floormap

import com.google.inject.Singleton
import com.habbokt.api.map.Tile
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class FloorMapPacketAssembler : PacketAssembler<FloorMapPacket>(Assembler(id = 470) {
    repeat(heightMap.sizeY) { y ->
        repeat(heightMap.sizeX) { x ->
            val tile = heightMap.tiles[Tile(x shl 8 or y)] // Inline
            require(tile != null)
            it.putStringHabbo(tile)
        }
        it.putStringHabbo(13.toChar().toString())
    }
})