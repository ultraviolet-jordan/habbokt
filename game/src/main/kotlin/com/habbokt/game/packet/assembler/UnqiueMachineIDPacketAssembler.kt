package com.habbokt.game.packet.assembler

import com.habbokt.game.buffer.putStringHabbo
import com.habbokt.game.packet.UniqueMachineIDPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.uniqueMachineIDPacket() {
    assemblePacket<UniqueMachineIDPacket>(439) {
        it.putStringHabbo(machineId)
    }
}