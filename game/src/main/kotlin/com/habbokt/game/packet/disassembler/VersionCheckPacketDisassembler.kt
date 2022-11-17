package com.habbokt.game.packet.disassembler

import com.habbokt.api.buffer.getIntHabbo
import com.habbokt.api.buffer.getStringHabbo
import com.habbokt.api.packet.disassembler.PacketDisassemblerConfig
import com.habbokt.api.packet.disassembler.packet
import com.habbokt.game.packet.VersionCheckPacket

/**
 * @author Jordan Abraham
 */
fun PacketDisassemblerConfig.installVersionCheckPacket() {
    packet(1170) {
        VersionCheckPacket(
            clientVersionId = it.getIntHabbo(),
            clientUrl = it.getStringHabbo(),
            clientVarsUrl = it.getStringHabbo()
        )
    }
}
