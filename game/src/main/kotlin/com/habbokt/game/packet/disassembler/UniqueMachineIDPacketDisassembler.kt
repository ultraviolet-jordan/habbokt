package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.UniqueMachineIDPacket
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installUniqueMachineIDPacket() {
    packet(id = 813) {
        UniqueMachineIDPacket(
            machineId = it.getStringHabbo()
        )
    }
}
