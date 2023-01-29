package com.habbokt.packet.dasm.room.getfloormap

import com.google.inject.Singleton
import com.habbokt.api.map.HeightMap
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.floormap.FloorMapPacket
import com.habbokt.packet.asm.room.users.UsersPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GetFloorMapPacketHandler : PacketHandler<GetFloorMapProxyPacket>(
    handler = {
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

        writePacket(FloorMapPacket(heightMap))
        writePacket(UsersPacket(emptyList()))
    }
)