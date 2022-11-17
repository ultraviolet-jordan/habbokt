package com.habbokt.game.plugin

import com.habbokt.api.plugin.PacketAssemblerPlugin
import com.habbokt.game.packet.assembler.installCompleteDiffieHandshakePacket
import com.habbokt.game.packet.assembler.installDisconnectReasonPacket
import com.habbokt.game.packet.assembler.installInitDiffieHandshakePacket
import com.habbokt.game.packet.assembler.installUniqueMachineIDPacket
import io.ktor.server.application.*
import io.ktor.server.application.Application

/**
 * @author Jordan Abraham
 */
fun Application.installPacketAssemblerPlugin() {
    install(PacketAssemblerPlugin) {
        installCompleteDiffieHandshakePacket()
        installDisconnectReasonPacket()
        installInitDiffieHandshakePacket()
        installUniqueMachineIDPacket()
    }
}