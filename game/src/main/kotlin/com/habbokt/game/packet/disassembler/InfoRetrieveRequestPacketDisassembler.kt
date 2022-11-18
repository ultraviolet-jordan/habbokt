package com.habbokt.game.packet.disassembler

import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet
import com.habbokt.api.packet.InfoRetrieveRequestPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installInfoRetrieveRequestPacket() {
    packet(id = 1817) {
        InfoRetrieveRequestPacket()
    }
}
