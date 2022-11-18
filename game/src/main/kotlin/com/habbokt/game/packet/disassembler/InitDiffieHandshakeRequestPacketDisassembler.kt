package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getIntHabbo
import com.habbokt.api.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installInitDiffieHandshakePacket() {
    packet(id = 206) {
        InitDiffieHandshakeRequestPacket(
            value = it.getIntHabbo() // Always 0
        )
    }
}
