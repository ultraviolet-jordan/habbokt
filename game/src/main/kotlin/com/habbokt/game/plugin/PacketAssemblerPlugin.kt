package com.habbokt.game.plugin

import com.habbokt.api.packet.assembler.assemblers
import com.habbokt.api.plugin.PacketAssemblerPlugin
import com.habbokt.game.packet.assembler.AuthenticationOKPacketAssembler
import com.habbokt.game.packet.assembler.ClientHelloPacketAssembler
import com.habbokt.game.packet.assembler.CompleteDiffieHandshakeResponsePacketAssembler
import com.habbokt.game.packet.assembler.DisconnectReasonPacketAssembler
import com.habbokt.game.packet.assembler.InitDiffieHandshakePacketAssembler
import com.habbokt.game.packet.assembler.ScrSendUserInfoPacketAssembler
import com.habbokt.game.packet.assembler.SessionParametersResponsePacketAssembler
import com.habbokt.game.packet.assembler.UniqueMachineIDPacketAssembler
import com.habbokt.game.packet.assembler.UserObjectPacketAssembler
import com.habbokt.game.packet.assembler.UserRightsPacketAssembler
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
            SessionParametersResponsePacketAssembler,
            UserRightsPacketAssembler,
            AuthenticationOKPacketAssembler,
            ClientHelloPacketAssembler,
            ScrSendUserInfoPacketAssembler,
            UserObjectPacketAssembler
        )
    }
}