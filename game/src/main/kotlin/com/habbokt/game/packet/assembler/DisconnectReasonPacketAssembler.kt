package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet
import com.habbokt.game.packet.DisconnectReasonPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installDisconnectReasonPacket() {
    packet<DisconnectReasonPacket>(id = 287) {
        it.putIntHabbo(reason.id)
    }
}