package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getIntHabbo
import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerListener
import com.habbokt.game.packet.VersionCheckPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerListener.versionCheckPacket() {
    disassemblePacket(1170) {
        VersionCheckPacket(
            clientVersionId = it.getIntHabbo(),
            clientUrl = it.getStringHabbo(),
            clientVarsUrl = it.getStringHabbo()
        )
    }
}
