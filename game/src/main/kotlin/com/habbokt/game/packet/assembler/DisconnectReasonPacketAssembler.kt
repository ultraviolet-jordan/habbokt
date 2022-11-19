package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putIntHabbo
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.assembler.*

/**
 * @author Jordan Abraham
 */
val DisconnectReasonPacketAssembler = assembler<DisconnectReasonPacket>(id = 287) {
    it.putIntHabbo(reason.id)
}