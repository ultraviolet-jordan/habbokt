package com.habbokt.packet

import com.habbokt.dao.DAOModule
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.asm.handshake.AuthenticationOKPacketAssembler
import com.habbokt.packet.asm.handshake.ClientHelloPacketAssembler
import com.habbokt.packet.asm.handshake.CompleteDiffieHandshakeResponsePacketAssembler
import com.habbokt.packet.asm.handshake.DisconnectReasonPacketAssembler
import com.habbokt.packet.asm.handshake.InitDiffieHandshakeResponsePacketAssembler
import com.habbokt.packet.asm.handshake.ScrSendUserInfoPacketAssembler
import com.habbokt.packet.asm.handshake.SessionParametersResponsePacketAssembler
import com.habbokt.packet.asm.handshake.UniqueMachineIdPacketAssembler
import com.habbokt.packet.asm.handshake.UserObjectPacketAssembler
import com.habbokt.packet.asm.handshake.UserRightsPacketAssembler
import com.habbokt.packet.dasm.PacketDisassembler
import com.habbokt.packet.dasm.handshake.CompleteDiffieHandshakeRequestPacketDisassembler
import com.habbokt.packet.dasm.handshake.InfoRetrievePacketDisassembler
import com.habbokt.packet.dasm.handshake.InitDiffieHandshakePacketDisassembler
import com.habbokt.packet.dasm.handshake.SSOTicketPacketDisassembler
import com.habbokt.packet.dasm.handshake.ScrGetUserInfoPacketDisassembler
import com.habbokt.packet.dasm.handshake.SessionParametersRequestPacketDisassembler
import com.habbokt.packet.dasm.handshake.UniqueMachineIdPacketDisassembler
import com.habbokt.packet.dasm.handshake.VersionCheckPacketDisassembler
import com.habbokt.packet.handler.PacketHandler
import com.habbokt.packet.handler.handshake.CompleteDiffieHandshakeRequestPacketHandler
import com.habbokt.packet.handler.handshake.InfoRetrievePacketHandler
import com.habbokt.packet.handler.handshake.InitDiffieHandshakeRequestPacketHandler
import com.habbokt.packet.handler.handshake.SSOTicketPacketHandler
import com.habbokt.packet.handler.handshake.ScrGetUserInfoPacketHandler
import com.habbokt.packet.handler.handshake.SessionParametersRequestPacketHandler
import com.habbokt.packet.handler.handshake.UniqueMachineIdPacketHandler
import com.habbokt.packet.handler.handshake.VersionCheckPacketHandler
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMultibinder

/**
 * @author Jordan Abraham
 */
object PacketModule : KotlinModule() {
    override fun configure() {
        install(DAOModule)

        // Assemblers
        val assemblers = KotlinMultibinder.newSetBinder<PacketAssembler<*>>(kotlinBinder)
        assemblers.addBinding().to<ClientHelloPacketAssembler>()
        assemblers.addBinding().to<InitDiffieHandshakeResponsePacketAssembler>()
        assemblers.addBinding().to<CompleteDiffieHandshakeResponsePacketAssembler>()
        assemblers.addBinding().to<DisconnectReasonPacketAssembler>()
        assemblers.addBinding().to<UniqueMachineIdPacketAssembler>()
        assemblers.addBinding().to<SessionParametersResponsePacketAssembler>()
        assemblers.addBinding().to<UserRightsPacketAssembler>()
        assemblers.addBinding().to<AuthenticationOKPacketAssembler>()
        assemblers.addBinding().to<ScrSendUserInfoPacketAssembler>()
        assemblers.addBinding().to<UserObjectPacketAssembler>()

        // Disassemblers
        val disassemblers = KotlinMultibinder.newSetBinder<PacketDisassembler>(kotlinBinder)
        disassemblers.addBinding().to<InitDiffieHandshakePacketDisassembler>()
        disassemblers.addBinding().to<CompleteDiffieHandshakeRequestPacketDisassembler>()
        disassemblers.addBinding().to<VersionCheckPacketDisassembler>()
        disassemblers.addBinding().to<UniqueMachineIdPacketDisassembler>()
        disassemblers.addBinding().to<SessionParametersRequestPacketDisassembler>()
        disassemblers.addBinding().to<SSOTicketPacketDisassembler>()
        disassemblers.addBinding().to<ScrGetUserInfoPacketDisassembler>()
        disassemblers.addBinding().to<InfoRetrievePacketDisassembler>()

        // Handlers
        val handlers = KotlinMultibinder.newSetBinder<PacketHandler<*>>(kotlinBinder)
        handlers.addBinding().to<InitDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding().to<CompleteDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding().to<VersionCheckPacketHandler>()
        handlers.addBinding().to<UniqueMachineIdPacketHandler>()
        handlers.addBinding().to<SessionParametersRequestPacketHandler>()
        handlers.addBinding().to<SSOTicketPacketHandler>()
        handlers.addBinding().to<ScrGetUserInfoPacketHandler>()
        handlers.addBinding().to<InfoRetrievePacketHandler>()
    }
}