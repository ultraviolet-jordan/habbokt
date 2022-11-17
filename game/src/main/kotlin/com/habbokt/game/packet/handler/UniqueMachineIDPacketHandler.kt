package com.habbokt.game.packet.handler

import com.habbokt.game.packet.UniqueMachineIDPacket
import java.util.UUID

/**
 * @author Jordan Abraham
 */
fun PacketHandlerListener.uniqueMachineIDPacket() {
    handlePacket<UniqueMachineIDPacket> {
        val machineId = packet.machineId.let {
            if (it.isEmpty() || it.length != 33 || it[0].toString() != "#") "#${UUID.randomUUID().toString().uppercase().replace("-", "")}"
            else it
        }
        // TODO Store this machineId somewhere.
        client.writePacket(UniqueMachineIDPacket(machineId))
    }
}