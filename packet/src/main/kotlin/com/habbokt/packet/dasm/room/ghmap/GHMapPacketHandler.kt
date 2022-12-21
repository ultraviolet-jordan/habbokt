package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.map.HeightMap
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.heightmap.HeightMapPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapPacketHandler : PacketHandler<GHMapProxyPacket>(Handler {
    val heightMap = HeightMap(
        """
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
            xxxxx000000000000xxxxx
        """.trimIndent()
    )

    it.writePacket(HeightMapPacket(heightMap))
})