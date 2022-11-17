package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerListener
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