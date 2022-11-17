package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerListener
import com.habbokt.game.packet.UniqueMachineIDPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerListener.uniqueMachineIDPacket() {
    assemblePacket<UniqueMachineIDPacket>(439) {
        it.putStringHabbo(machineId)
    }
}