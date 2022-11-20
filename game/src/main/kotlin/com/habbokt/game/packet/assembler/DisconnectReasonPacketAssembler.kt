package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putIntHabbo
import com.habbokt.api.packet.DisconnectReasonPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val DisconnectReasonPacketAssembler = assembler<DisconnectReasonPacket>(id = 287) {
    it.putIntHabbo(reason.id)
}