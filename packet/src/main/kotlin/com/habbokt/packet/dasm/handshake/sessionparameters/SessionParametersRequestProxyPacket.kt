package com.habbokt.packet.dasm.handshake.sessionparameters

import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.ProxyPacket

/**
 * @author Jordan Abraham
 */
data class SessionParametersRequestProxyPacket(
    val sessionParameters: SessionParameters
) : ProxyPacket