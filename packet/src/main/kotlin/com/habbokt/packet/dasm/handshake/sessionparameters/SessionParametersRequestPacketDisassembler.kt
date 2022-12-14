package com.habbokt.packet.dasm.handshake.sessionparameters

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestPacketDisassembler : PacketDisassembler(Disassembler {
    SessionParametersRequestPacket()
})