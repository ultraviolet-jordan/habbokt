package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.api.packet.assembler.*

/**
 * @author Jordan Abraham
 */
val InitDiffieHandshakePacketAssembler = assembler<InitDiffieHandshakeResponsePacket>(id = 277) {
    it.putStringHabbo(securityCastToken)
    it.putIntHabbo(serverToClient)
}