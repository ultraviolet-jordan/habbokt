package com.habbokt.packet.dasm.room.gusrs

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GUsrsPacketDisassembler : PacketDisassembler(Disassembler {
    GUsrsPacket.Empty
})