package com.habbokt.game.packet.disassembler

import com.habbokt.api.common.getIntHabbo
import com.habbokt.api.packet.InitDiffieHandshakeRequestPacket
import com.habbokt.api.packet.disassembler.disassembler

/**
 * @author Jordan Abraham
 */
val InitDiffieHandshakePacketDisassembler = disassembler(id = 206) {
    InitDiffieHandshakeRequestPacket(
        value = it.getIntHabbo() // Always 0
    )
}
