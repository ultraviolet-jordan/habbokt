package com.habbokt.packet.dasm.handshake.sessionparameters

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestPacketDisassembler : PacketDisassembler<SessionParametersRequestPacket>(
    body = { SessionParametersRequestPacket.Empty }
)