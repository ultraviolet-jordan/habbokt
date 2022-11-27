package com.habbokt.packet

import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class SessionParametersResponsePacket(
    val sessionParameters: SessionParameters
) : Packet