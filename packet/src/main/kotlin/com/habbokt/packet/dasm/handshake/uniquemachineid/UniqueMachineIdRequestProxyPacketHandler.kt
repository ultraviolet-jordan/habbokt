package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyPacketHandler
import java.util.UUID

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdRequestProxyPacketHandler : ProxyPacketHandler<UniqueMachineIdRequestPacket, UniqueMachineIdRequestProxyPacket>(
    handler = {
        val id = if (it.machineId.isEmpty() || (it.machineId.length != 33) || (it.machineId[0] != '#')) "#${UUID.randomUUID().toString().uppercase().replace("-", "")}"
        else it.machineId

        UniqueMachineIdRequestProxyPacket(id)
    }
)