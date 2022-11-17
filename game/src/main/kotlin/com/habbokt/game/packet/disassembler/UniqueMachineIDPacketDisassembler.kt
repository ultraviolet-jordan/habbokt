package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerListener
import com.habbokt.game.packet.UniqueMachineIDPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerListener.uniqueMachineIDPacket() {
    disassemblePacket(813) {
        UniqueMachineIDPacket(
            machineId = it.getStringHabbo()
        )
    }
}
