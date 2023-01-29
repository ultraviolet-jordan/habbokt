package com.habbokt.packet.dasm.handshake.sessionparameters

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.sessionparameters.SessionParametersResponsePacket

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestPacketHandler : PacketHandler<SessionParametersRequestProxyPacket>(
    handler = {
        writePacket(
            SessionParametersResponsePacket(
                sessionParameters = it.sessionParameters
            )
        )
    }
)