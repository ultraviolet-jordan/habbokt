package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet
import com.habbokt.game.packet.UniqueMachineIDPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installUniqueMachineIDPacket() {
    packet(813) {
        UniqueMachineIDPacket(
            machineId = it.getStringHabbo()
        )
    }
}
