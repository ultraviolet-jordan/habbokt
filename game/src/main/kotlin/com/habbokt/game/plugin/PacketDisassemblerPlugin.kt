package com.habbokt.game.plugin

import com.habbokt.api.plugin.PacketDisassemblerPlugin
import com.habbokt.game.packet.disassembler.installCompleteDiffieHandshakePacket
import com.habbokt.game.packet.disassembler.installInfoRetrieveRequestPacket
import com.habbokt.game.packet.disassembler.installInitDiffieHandshakePacket
import com.habbokt.game.packet.disassembler.installSSOTicketPacket
import com.habbokt.game.packet.disassembler.installUniqueMachineIDPacket
import com.habbokt.game.packet.disassembler.installVersionCheckPacket
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketDisassemblerPlugin() {
    install(PacketDisassemblerPlugin) {
        installCompleteDiffieHandshakePacket()
        installInitDiffieHandshakePacket()
        installUniqueMachineIDPacket()
        installVersionCheckPacket()
        installInfoRetrieveRequestPacket()
        installSSOTicketPacket()
    }
}