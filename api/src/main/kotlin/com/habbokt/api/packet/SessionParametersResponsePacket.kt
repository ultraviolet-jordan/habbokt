package com.habbokt.api.packet

import com.habbokt.api.client.handshake.SessionParameters

/**
 * @author Jordan Abraham
 */
data class SessionParametersResponsePacket(
    val sessionParameters: SessionParameters
) : Packet