package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet
import com.habbokt.api.packet.CompleteDiffieHandshakeRequestPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installCompleteDiffieHandshakePacket() {
    packet(id = 2002) {
        CompleteDiffieHandshakeRequestPacket(
            publicKey = it.getStringHabbo()
        )
    }
}
