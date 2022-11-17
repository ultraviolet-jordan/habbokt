package com.habbokt.game.plugin

import com.habbokt.api.plugin.PacketHandlerPlugin
import com.habbokt.game.packet.handler.installCompleteDiffieHandshakePacket
import com.habbokt.game.packet.handler.installInitDiffieHandshakePacket
import com.habbokt.game.packet.handler.installUniqueMachineIDPacket
import com.habbokt.game.packet.handler.installVersionCheckPacket
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketHandlerPlugin() {
    install(PacketHandlerPlugin) {
        installCompleteDiffieHandshakePacket()
        installInitDiffieHandshakePacket()
        installUniqueMachineIDPacket()
        installVersionCheckPacket()
    }
}