package com.habbokt.game.packet.assembler

import com.habbokt.game.buffer.putIntHabbo
import com.habbokt.game.buffer.putStringHabbo
import com.habbokt.game.packet.InitDiffieHandshakeResponsePacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.initDiffieHandshakePacket() {
    assemblePacket<InitDiffieHandshakeResponsePacket>(277) {
        it.putStringHabbo(securityCastToken)
        it.putIntHabbo(serverToClient)
    }
}