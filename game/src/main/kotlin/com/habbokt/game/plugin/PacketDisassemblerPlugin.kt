package com.habbokt.game.plugin

import com.habbokt.api.packet.disassembler.*
import com.habbokt.api.plugin.PacketDisassemblerPlugin
import com.habbokt.game.packet.disassembler.*
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketDisassemblerPlugin() {
    install(PacketDisassemblerPlugin) {
        disassemblers(
            CompleteDiffieHandshakeRequestPacketDisassembler,
            InitDiffieHandshakePacketDisassembler,
            UniqueMachineIDPacketDisassembler,
            VersionCheckPacketDisassembler,
            SessionParametersRequestPacketDisassembler,
            SSOTicketPacketDisassembler,
            ScrGetUserInfoPacketDisassembler,
            InfoRetrievePacketDisassembler
        )
    }
}