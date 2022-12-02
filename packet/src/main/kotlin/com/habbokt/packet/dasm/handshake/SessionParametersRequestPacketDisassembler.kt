package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.SessionParametersRequestPacket
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class SessionParametersRequestPacketDisassembler : PacketDisassembler(Disassembler {
    SessionParametersRequestPacket()
})