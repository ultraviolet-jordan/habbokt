package com.habbokt.game.plugin

import com.habbokt.api.packet.disassembler.disassemblers
import com.habbokt.api.plugin.PacketDisassemblerPlugin
import com.habbokt.game.packet.disassembler.CompleteDiffieHandshakeRequestPacketDisassembler
import com.habbokt.game.packet.disassembler.InfoRetrievePacketDisassembler
import com.habbokt.game.packet.disassembler.InitDiffieHandshakePacketDisassembler
import com.habbokt.game.packet.disassembler.SSOTicketPacketDisassembler
import com.habbokt.game.packet.disassembler.ScrGetUserInfoPacketDisassembler
import com.habbokt.game.packet.disassembler.SessionParametersRequestPacketDisassembler
import com.habbokt.game.packet.disassembler.UniqueMachineIDPacketDisassembler
import com.habbokt.game.packet.disassembler.VersionCheckPacketDisassembler
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