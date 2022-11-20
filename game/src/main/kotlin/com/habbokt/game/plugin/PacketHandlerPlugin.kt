package com.habbokt.game.plugin

import com.habbokt.api.packet.handler.*
import com.habbokt.api.plugin.PacketHandlerPlugin
import com.habbokt.game.packet.handler.*
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketHandlerPlugin() {
    install(PacketHandlerPlugin) {
        handlers(
            CompleteDiffieHandshakeRequestPacketHandler,
            InitDiffieHandshakeRequestPacketHandler,
            UniqueMachineIDPacketHandler,
            VersionCheckPacketHandler,
            SessionParametersRequestPacketHandler,
            SSOTicketPacketHandler,
            ScrGetUserInfoPacketHandler,
            InfoRetrievePacketHandler
        )
    }
}