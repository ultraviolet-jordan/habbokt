package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.putStringHabbo
import com.habbokt.api.packet.UniqueMachineIDPacket
import com.habbokt.api.packet.assembler.PacketAssemblerConfig
import com.habbokt.api.packet.assembler.packet

/**
 * @author Jordan Abraham
 */
fun PacketAssemblerConfig.installUniqueMachineIDPacket() {
    packet<UniqueMachineIDPacket>(id = 439) {
        it.putStringHabbo(machineId)
    }
}