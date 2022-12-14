package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class UniqueMachineIdRequestProxyPacket(
    val machineId: String
) : ProxyPacket