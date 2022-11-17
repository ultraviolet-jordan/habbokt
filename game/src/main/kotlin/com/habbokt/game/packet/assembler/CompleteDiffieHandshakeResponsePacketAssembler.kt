package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerListener
import com.habbokt.game.packet.CompleteDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.completeDiffieHandshakePacket() {
    assemblePacket<CompleteDiffieHandshakeResponsePacket>(1) {
        it.putStringHabbo(secretKey)
    }
}