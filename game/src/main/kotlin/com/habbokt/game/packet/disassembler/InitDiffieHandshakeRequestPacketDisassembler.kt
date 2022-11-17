package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getIntHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet
import com.habbokt.game.packet.InitDiffieHandshakeRequestPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installInitDiffieHandshakePacket() {
    packet(206) {
        InitDiffieHandshakeRequestPacket(
            value = it.getIntHabbo() // Always 0
        )
    }
}
