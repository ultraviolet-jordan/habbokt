package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet
import com.habbokt.api.packet.UniqueMachineIDPacket

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installUniqueMachineIDPacket() {
    packet<UniqueMachineIDPacket>(id = 439) {
        it.putStringHabbo(machineId)
    }
}