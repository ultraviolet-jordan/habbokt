package com.habbokt.packet.dasm.room.ghmap

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class GHMapPacketDisassembler : PacketDisassembler<GHMapPacket>(
    body = { GHMapPacket.Empty }
)