package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val CompleteDiffieHandshakeResponsePacketAssembler = assembler<CompleteDiffieHandshakeResponsePacket>(id = 1) {
    it.putStringHabbo(secretKey)
}