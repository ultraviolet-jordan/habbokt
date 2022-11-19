package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.UniqueMachineIDPacket
import com.habbokt.api.packet.assembler.*

/**
 * @author Jordan Abraham
 */
val UniqueMachineIDPacketAssembler = assembler<UniqueMachineIDPacket>(id = 439) {
    it.putStringHabbo(machineId)
}