package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrievePacketDisassembler : PacketDisassembler(Disassembler(id = 7) {
    InfoRetrievePacket()
})