package com.habbokt.game.packet.disassembler

import com.habbokt.game.buffer.getIntHabbo
import com.habbokt.game.buffer.getStringHabbo
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
