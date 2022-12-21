package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapPacketDisassembler : PacketDisassembler(Disassembler {
    GHMapPacket.Empty
})