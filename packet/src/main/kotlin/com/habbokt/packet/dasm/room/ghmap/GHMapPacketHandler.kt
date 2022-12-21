package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.map.HeightMap
import com.habbokt.api.map.Tile
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.heightmap.HeightMapPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapPacketHandler : PacketHandler<GHMapProxyPacket>(Handler {
    val layout = """
            xxxxxxxxxxxxxxxx000000|
            xxxxx0xxxxxxxxxx000000|
            xxxxx00000000xxx000000|
            xxxxx000000000xx000000|
            0000000000000000000000|
            0000000000000000000000|
            0000000000000000000000|
            0000000000000000000000|
            0000000000000000000000|
            xxxxx000000000000000xx|
            xxxxx000000000000000xx|
            x0000000000000000000xx|
            x0000000000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxxxx0000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxxxx000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxxx00000000000xxxxx|
            xxxxx000000000000xxxxx|
            xxxxx000000000000xxxxx"""
        .trimIndent()
        .replace("\n", "")

    it.writePacket(HeightMapPacket(layout.heightmapFromString()))
})

private fun String.heightmapFromString(): HeightMap {
    val tiles = split("|")
    val sizeY = tiles.size
    val sizeX = tiles.maxBy { it.length }.length
    return HeightMap(
        sizeX = sizeX,
        sizeY = sizeY,
        tiles = buildMap {
            repeat(sizeY) { y ->
                repeat(sizeX) { x ->
                    this[Tile(x shl 8 or y)] = tiles[y][x].toString()
                }
            }
        }
    )
}