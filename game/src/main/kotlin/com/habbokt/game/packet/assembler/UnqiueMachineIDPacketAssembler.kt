package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.packet.UniqueMachineIDPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val UniqueMachineIDPacketAssembler = assembler<UniqueMachineIDPacket>(id = 439) {
    it.putStringHabbo(machineId)
}