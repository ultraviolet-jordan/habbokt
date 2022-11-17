package com.habbokt.game.packet.disassembler

import com.habbokt.game.buffer.getStringHabbo
import com.habbokt.game.packet.CompleteDiffieHandshakeRequestPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerListener.completeDiffieHandshakePacket() {
    disassemblePacket(2002) {
        CompleteDiffieHandshakeRequestPacket(
            publicKey = it.getStringHabbo()
        )
    }
}
