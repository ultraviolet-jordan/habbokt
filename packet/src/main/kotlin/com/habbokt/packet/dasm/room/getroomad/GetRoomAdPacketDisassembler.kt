package com.habbokt.packet.dasm.room.getroomad

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRoomAdPacketDisassembler : PacketDisassembler<GetRoomAdPacket>(
    body = { GetRoomAdPacket.Empty }
)