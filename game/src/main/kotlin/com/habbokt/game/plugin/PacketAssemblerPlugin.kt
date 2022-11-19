package com.habbokt.game.plugin

import com.habbokt.api.packet.assembler.assemblers
import com.habbokt.api.plugin.PacketAssemblerPlugin
import com.habbokt.game.packet.assembler.*
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketAssemblerPlugin() {
    install(PacketAssemblerPlugin) {
        assemblers(
            CompleteDiffieHandshakeResponsePacketAssembler,
            DisconnectReasonPacketAssembler,
            InitDiffieHandshakePacketAssembler,
            UniqueMachineIDPacketAssembler,
            InfoRetrieveResponsePacketAssembler,
            UserRightsPacketAssembler,
            AuthenticationOKPacketAssembler,
            ClientHelloPacketAssembler
        )
    }
}