package com.habbokt.packet.dasm.room.gusrs

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GUsrsPacketDisassembler : PacketDisassembler<GUsrsPacket>(
    body = { GUsrsPacket.Empty }
)