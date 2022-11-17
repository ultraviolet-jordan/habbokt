package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerListener
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
