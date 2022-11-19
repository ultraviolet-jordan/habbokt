package com.habbokt.game.plugin

import com.habbokt.api.plugin.PacketAssemblerPlugin
import com.habbokt.game.packet.assembler.installAuthenticationOKPacket
import com.habbokt.game.packet.assembler.installClientHelloPacket
import com.habbokt.game.packet.assembler.installCompleteDiffieHandshakePacket
import com.habbokt.game.packet.assembler.installDisconnectReasonPacket
import com.habbokt.game.packet.assembler.installInfoRetrieveResponsePacket
import com.habbokt.game.packet.assembler.installInitDiffieHandshakePacket
import com.habbokt.game.packet.assembler.installUniqueMachineIDPacket
import com.habbokt.game.packet.assembler.installUserRightsPacket
import io.ktor.server.application.Application
import io.ktor.server.application.install

/**
 * @author Jordan Abraham
 */
fun Application.installPacketAssemblerPlugin() {
    install(PacketAssemblerPlugin) {
        installCompleteDiffieHandshakePacket()
        installDisconnectReasonPacket()
        installInitDiffieHandshakePacket()
        installUniqueMachineIDPacket()
        installInfoRetrieveResponsePacket()
        installUserRightsPacket()
        installAuthenticationOKPacket()
        installClientHelloPacket()
    }
}