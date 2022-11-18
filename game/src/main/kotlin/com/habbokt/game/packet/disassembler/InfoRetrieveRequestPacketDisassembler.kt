package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.InfoRetrieveRequestPacket
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installInfoRetrieveRequestPacket() {
    packet(id = 1817) {
        InfoRetrieveRequestPacket()
    }
}
