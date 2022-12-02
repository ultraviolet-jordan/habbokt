package com.habbokt.packet

import com.habbokt.api.packet.Packet
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
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMapBinder
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
object PacketModule : KotlinModule() {
    override fun configure() {
        install(DAOModule)

        // Assemblers
        val assemblers = KotlinMapBinder.newMapBinder<KClass<*>, PacketAssembler<Packet>>(kotlinBinder)
        assemblers.addBinding(ClientHelloPacket::class).to<ClientHelloPacketAssembler>()
        assemblers.addBinding(InitDiffieHandshakeResponsePacket::class).to<InitDiffieHandshakeResponsePacketAssembler>()
        assemblers.addBinding(CompleteDiffieHandshakeResponsePacket::class).to<CompleteDiffieHandshakeResponsePacketAssembler>()
        assemblers.addBinding(DisconnectReasonPacket::class).to<DisconnectReasonPacketAssembler>()
        assemblers.addBinding(UniqueMachineIdPacket::class).to<UniqueMachineIdPacketAssembler>()
        assemblers.addBinding(SessionParametersResponsePacket::class).to<SessionParametersResponsePacketAssembler>()
        assemblers.addBinding(UserRightsPacket::class).to<UserRightsPacketAssembler>()
        assemblers.addBinding(AuthenticationOKPacket::class).to<AuthenticationOKPacketAssembler>()
        assemblers.addBinding(ScrSendUserInfoPacket::class).to<ScrSendUserInfoPacketAssembler>()
        assemblers.addBinding(UserObjectPacket::class).to<UserObjectPacketAssembler>()

        // Disassemblers
        val disassemblers = KotlinMapBinder.newMapBinder<Int, PacketDisassembler>(kotlinBinder)
        disassemblers.addBinding(206).to<InitDiffieHandshakePacketDisassembler>()
        disassemblers.addBinding(2002).to<CompleteDiffieHandshakeRequestPacketDisassembler>()
        disassemblers.addBinding(1170).to<VersionCheckPacketDisassembler>()
        disassemblers.addBinding(813).to<UniqueMachineIdPacketDisassembler>()
        disassemblers.addBinding(1817).to<SessionParametersRequestPacketDisassembler>()
        disassemblers.addBinding(204).to<SSOTicketPacketDisassembler>()
        disassemblers.addBinding(26).to<ScrGetUserInfoPacketDisassembler>()
        disassemblers.addBinding(7).to<InfoRetrievePacketDisassembler>()

        // Handlers
        val handlers = KotlinMapBinder.newMapBinder<KClass<*>, PacketHandler<Packet>>(kotlinBinder)
        handlers.addBinding(InitDiffieHandshakeRequestPacket::class).to<InitDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding(CompleteDiffieHandshakeRequestPacket::class).to<CompleteDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding(VersionCheckPacket::class).to<VersionCheckPacketHandler>()
        handlers.addBinding(UniqueMachineIdPacket::class).to<UniqueMachineIdPacketHandler>()
        handlers.addBinding(SessionParametersRequestPacket::class).to<SessionParametersRequestPacketHandler>()
        handlers.addBinding(SSOTicketPacket::class).to<SSOTicketPacketHandler>()
        handlers.addBinding(ScrGetUserInfoPacket::class).to<ScrGetUserInfoPacketHandler>()
        handlers.addBinding(InfoRetrievePacket::class).to<InfoRetrievePacketHandler>()
    }
}