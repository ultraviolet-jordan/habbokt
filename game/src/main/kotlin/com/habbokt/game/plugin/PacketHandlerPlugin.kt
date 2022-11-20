package com.habbokt.game.plugin

import com.habbokt.api.packet.handler.handlers
import com.habbokt.api.plugin.PacketHandlerPlugin
import com.habbokt.game.packet.handler.CompleteDiffieHandshakeRequestPacketHandler
import com.habbokt.game.packet.handler.InfoRetrievePacketHandler
import com.habbokt.game.packet.handler.InitDiffieHandshakeRequestPacketHandler
import com.habbokt.game.packet.handler.SSOTicketPacketHandler
import com.habbokt.game.packet.handler.ScrGetUserInfoPacketHandler
import com.habbokt.game.packet.handler.SessionParametersRequestPacketHandler
import com.habbokt.game.packet.handler.UniqueMachineIDPacketHandler
import com.habbokt.game.packet.handler.VersionCheckPacketHandler
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