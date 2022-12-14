package com.habbokt.packet.dasm.handshake.inforetrieve

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrievePacketDisassembler : PacketDisassembler(Disassembler {
    InfoRetrievePacket()
})