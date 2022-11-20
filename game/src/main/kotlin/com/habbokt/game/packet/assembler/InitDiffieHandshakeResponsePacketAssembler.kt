package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putIntHabbo
import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.packet.InitDiffieHandshakeResponsePacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val InitDiffieHandshakePacketAssembler = assembler<InitDiffieHandshakeResponsePacket>(id = 277) {
    it.putStringHabbo(securityCastToken)
    it.putIntHabbo(serverToClient)
}