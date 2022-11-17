package com.habbokt.game.packet.disassembler

import com.habbokt.game.buffer.getStringHabbo
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
