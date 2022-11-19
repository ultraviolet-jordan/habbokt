package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getIntHabbo
import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.VersionCheckPacket
import com.habbokt.api.packet.disassembler.*

/**
 * @author Jordan Abraham
 */
val VersionCheckPacketDisassembler = disassembler(id = 1170) {
    VersionCheckPacket(
        clientVersionId = it.getIntHabbo(),
        clientUrl = it.getStringHabbo(),
        clientVarsUrl = it.getStringHabbo()
    )
}
