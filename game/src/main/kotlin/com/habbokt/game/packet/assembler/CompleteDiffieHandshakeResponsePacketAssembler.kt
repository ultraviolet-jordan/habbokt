package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.api.packet.assembler.*

/**
 * @author Jordan Abraham
 */
val CompleteDiffieHandshakeResponsePacketAssembler = assembler<CompleteDiffieHandshakeResponsePacket>(id = 1) {
    it.putStringHabbo(secretKey)
}