package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.ProxyHandler
import com.habbokt.api.packet.ProxyPacketHandler
import java.util.UUID

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdRequestProxyPacketHandler : ProxyPacketHandler<UniqueMachineIdRequestPacket>(ProxyHandler {
    val id = if (machineId.isEmpty() || (machineId.length != 33) || (machineId[0] != '#')) "#${UUID.randomUUID().toString().uppercase().replace("-", "")}"
    else machineId

    return@ProxyHandler UniqueMachineIdRequestProxyPacket(id)
})