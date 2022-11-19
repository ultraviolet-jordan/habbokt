package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.UniqueMachineIDPacket
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val UniqueMachineIDPacketDisassembler = disassembler(id = 813) {
    UniqueMachineIDPacket(
        machineId = it.getStringHabbo()
    )
}
