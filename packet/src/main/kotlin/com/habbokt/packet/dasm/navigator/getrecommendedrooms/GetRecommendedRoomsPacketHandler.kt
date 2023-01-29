package com.habbokt.packet.dasm.navigator.getrecommendedrooms

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.navigater.recommendroomlist.RecommendRoomListPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRecommendedRoomsPacketHandler : PacketHandler<GetRecommendedRoomsProxyPacket>(
    handler = {
        writePacket(
            RecommendRoomListPacket(
                rooms = emptyList()
            )
        )
    }
)