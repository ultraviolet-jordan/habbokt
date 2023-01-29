package com.habbokt.packet.dasm.room.getfloormap

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetFloorMapPacketDisassembler : PacketDisassembler<GetFloorMapPacket>(
    body = { GetFloorMapPacket.Empty }
)