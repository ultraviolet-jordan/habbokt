package com.habbokt.game.packet.disassembler

import com.habbokt.api.common.getIntHabbo
import com.habbokt.api.common.getStringHabbo
import com.habbokt.api.packet.VersionCheckPacket
import com.habbokt.api.packet.disassembler.disassembler

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
