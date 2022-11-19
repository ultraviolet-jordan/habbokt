package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val CompleteDiffieHandshakeRequestPacketDisassembler = disassembler(id = 2002) {
    CompleteDiffieHandshakeRequestPacket(
        publicKey = it.getStringHabbo()
    )
}
