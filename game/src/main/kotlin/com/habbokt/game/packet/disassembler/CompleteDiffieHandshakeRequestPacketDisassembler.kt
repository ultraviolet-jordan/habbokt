package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet

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
