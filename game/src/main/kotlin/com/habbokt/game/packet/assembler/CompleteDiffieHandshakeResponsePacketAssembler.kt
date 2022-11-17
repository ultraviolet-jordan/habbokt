package com.habbokt.game.packet.assembler

import com.habbokt.game.buffer.putStringHabbo
import com.habbokt.game.packet.CompleteDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.completeDiffieHandshakePacket() {
    assemblePacket<CompleteDiffieHandshakeResponsePacket>(1) {
        it.putStringHabbo(secretKey)
    }
}