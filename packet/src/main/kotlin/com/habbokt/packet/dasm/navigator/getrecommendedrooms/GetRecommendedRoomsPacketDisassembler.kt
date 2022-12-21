package com.habbokt.packet.dasm.navigator.getrecommendedrooms

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GetRecommendedRoomsPacketDisassembler : PacketDisassembler(Disassembler {
    GetRecommendedRoomsPacket.Empty
})