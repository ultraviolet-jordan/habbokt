package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.VersionCheckPacket
import com.habbokt.packet.buf.getIntHabbo
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.PacketDisassembler

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckPacketDisassembler : PacketDisassembler(Disassembler {
    VersionCheckPacket(
        clientVersionId = it.getIntHabbo(),
        clientUrl = it.getStringHabbo(),
        clientVarsUrl = it.getStringHabbo()
    )
})