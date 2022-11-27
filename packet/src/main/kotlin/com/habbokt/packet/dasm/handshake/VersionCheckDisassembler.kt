package com.habbokt.packet.dasm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.VersionCheckPacket
import com.habbokt.packet.buf.getIntHabbo
import com.habbokt.packet.buf.getStringHabbo
import com.habbokt.packet.dasm.Disassembler
import com.habbokt.packet.dasm.DisassemblerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class VersionCheckDisassembler : DisassemblerListener(Disassembler(id = 1170) {
    VersionCheckPacket(
        clientVersionId = it.getIntHabbo(),
        clientUrl = it.getStringHabbo(),
        clientVarsUrl = it.getStringHabbo()
    )
})