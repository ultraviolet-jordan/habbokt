package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerListener
import com.habbokt.game.packet.DisconnectReasonPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.disconnectReasonPacket() {
    assemblePacket<DisconnectReasonPacket>(287) {
        it.putIntHabbo(reason.id)
    }
}