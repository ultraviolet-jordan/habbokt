package com.habbokt.game.packet.assembler

import com.habbokt.game.buffer.putIntHabbo
import com.habbokt.game.packet.DisconnectReasonPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.disconnectReasonPacket() {
    assemblePacket<DisconnectReasonPacket>(287) {
        it.putIntHabbo(reason.id)
    }
}