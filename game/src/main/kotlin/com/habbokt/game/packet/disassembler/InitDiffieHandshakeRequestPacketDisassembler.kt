package com.habbokt.game.packet.disassembler

import com.habbokt.game.buffer.getIntHabbo
import com.habbokt.game.packet.InitDiffieHandshakeRequestPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerListener.initDiffieHandshakePacket() {
    disassemblePacket(206) {
        InitDiffieHandshakeRequestPacket(
            value = it.getIntHabbo() // Always 0
        )
    }
}
