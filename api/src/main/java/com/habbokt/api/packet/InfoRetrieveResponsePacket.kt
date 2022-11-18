package com.habbokt.api.packet

import com.habbokt.api.client.handshake.SessionParameters
import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
data class InfoRetrieveResponsePacket(
    val sessionParameters: SessionParameters
) : Packet