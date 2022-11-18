package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet
import com.habbokt.api.packet.CompleteDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installCompleteDiffieHandshakePacket() {
    packet<CompleteDiffieHandshakeResponsePacket>(id = 1) {
        it.putStringHabbo(secretKey)
    }
}