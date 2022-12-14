package com.habbokt.packet.asm.handshake.sessionparameters

import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class SessionParametersResponsePacket(
    val sessionParameters: SessionParameters
) : Packet