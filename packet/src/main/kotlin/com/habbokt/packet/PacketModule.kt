package com.habbokt.packet

import com.habbokt.api.packet.Packet
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.api.packet.ProxyPacket
import com.habbokt.api.packet.ProxyPacketHandler
import com.habbokt.dao.DAOModule
import com.habbokt.packet.asm.handshake.authenticationok.AuthenticationOKPacket
import com.habbokt.packet.asm.handshake.authenticationok.AuthenticationOKPacketAssembler
import com.habbokt.packet.asm.handshake.clienthello.ClientHelloPacket
import com.habbokt.packet.asm.handshake.clienthello.ClientHelloPacketAssembler
import com.habbokt.packet.asm.handshake.completediffiehandshake.CompleteDiffieHandshakeResponsePacket
import com.habbokt.packet.asm.handshake.completediffiehandshake.CompleteDiffieHandshakeResponsePacketAssembler
import com.habbokt.packet.asm.handshake.disconnectreason.DisconnectReasonPacket
import com.habbokt.packet.asm.handshake.disconnectreason.DisconnectReasonPacketAssembler
import com.habbokt.packet.asm.handshake.initdiffiehandshake.InitDiffieHandshakeResponsePacket
import com.habbokt.packet.asm.handshake.initdiffiehandshake.InitDiffieHandshakeResponsePacketAssembler
import com.habbokt.packet.asm.handshake.scrsenduserinfo.ScrSendUserInfoPacket
import com.habbokt.packet.asm.handshake.scrsenduserinfo.ScrSendUserInfoPacketAssembler
import com.habbokt.packet.asm.handshake.sessionparameters.SessionParametersResponsePacket
import com.habbokt.packet.asm.handshake.sessionparameters.SessionParametersResponsePacketAssembler
import com.habbokt.packet.asm.handshake.uniquemachineid.UniqueMachineIdResponsePacket
import com.habbokt.packet.asm.handshake.uniquemachineid.UniqueMachineIdResponsePacketAssembler
import com.habbokt.packet.asm.handshake.userobject.UserObjectPacket
import com.habbokt.packet.asm.handshake.userobject.UserObjectPacketAssembler
import com.habbokt.packet.asm.handshake.userrights.UserRightsPacket
import com.habbokt.packet.asm.handshake.userrights.UserRightsPacketAssembler
import com.habbokt.packet.asm.navigater.navnodeinfo.NavNodeInfoPacket
import com.habbokt.packet.asm.navigater.navnodeinfo.NavNodeInfoPacketAssembler
import com.habbokt.packet.dasm.handshake.completediffiehandshake.CompleteDiffieHandshakeRequestPacket
import com.habbokt.packet.dasm.handshake.completediffiehandshake.CompleteDiffieHandshakeRequestPacketDisassembler
import com.habbokt.packet.dasm.handshake.completediffiehandshake.CompleteDiffieHandshakeRequestPacketHandler
import com.habbokt.packet.dasm.handshake.completediffiehandshake.CompleteDiffieHandshakeRequestProxyPacket
import com.habbokt.packet.dasm.handshake.completediffiehandshake.CompleteDiffieHandshakeRequestProxyPacketHandler
import com.habbokt.packet.dasm.handshake.inforetrieve.InfoRetrievePacket
import com.habbokt.packet.dasm.handshake.inforetrieve.InfoRetrievePacketDisassembler
import com.habbokt.packet.dasm.handshake.inforetrieve.InfoRetrievePacketHandler
import com.habbokt.packet.dasm.handshake.inforetrieve.InfoRetrieveProxyPacket
import com.habbokt.packet.dasm.handshake.inforetrieve.InfoRetrieveProxyPacketHandler
import com.habbokt.packet.dasm.handshake.initdiffiehandshake.InitDiffieHandshakePacketDisassembler
import com.habbokt.packet.dasm.handshake.initdiffiehandshake.InitDiffieHandshakeRequestPacket
import com.habbokt.packet.dasm.handshake.initdiffiehandshake.InitDiffieHandshakeRequestPacketHandler
import com.habbokt.packet.dasm.handshake.initdiffiehandshake.InitDiffieHandshakeRequestProxyPacket
import com.habbokt.packet.dasm.handshake.initdiffiehandshake.InitDiffieHandshakeRequestProxyPacketHandler
import com.habbokt.packet.dasm.handshake.scrgetuserinfo.ScrGetUserInfoPacket
import com.habbokt.packet.dasm.handshake.scrgetuserinfo.ScrGetUserInfoPacketDisassembler
import com.habbokt.packet.dasm.handshake.scrgetuserinfo.ScrGetUserInfoPacketHandler
import com.habbokt.packet.dasm.handshake.scrgetuserinfo.ScrGetUserInfoProxyPacket
import com.habbokt.packet.dasm.handshake.scrgetuserinfo.ScrGetUserInfoProxyPacketHandler
import com.habbokt.packet.dasm.handshake.sessionparameters.SessionParametersRequestPacket
import com.habbokt.packet.dasm.handshake.sessionparameters.SessionParametersRequestPacketDisassembler
import com.habbokt.packet.dasm.handshake.sessionparameters.SessionParametersRequestPacketHandler
import com.habbokt.packet.dasm.handshake.sessionparameters.SessionParametersRequestProxyPacket
import com.habbokt.packet.dasm.handshake.sessionparameters.SessionParametersRequestProxyPacketHandler
import com.habbokt.packet.dasm.handshake.ssoticket.SSOTicketPacket
import com.habbokt.packet.dasm.handshake.ssoticket.SSOTicketPacketDisassembler
import com.habbokt.packet.dasm.handshake.ssoticket.SSOTicketPacketHandler
import com.habbokt.packet.dasm.handshake.ssoticket.SSOTicketProxyPacket
import com.habbokt.packet.dasm.handshake.ssoticket.SSOTicketProxyPacketHandler
import com.habbokt.packet.dasm.handshake.uniquemachineid.UniqueMachineIdRequestPacket
import com.habbokt.packet.dasm.handshake.uniquemachineid.UniqueMachineIdRequestPacketDisassembler
import com.habbokt.packet.dasm.handshake.uniquemachineid.UniqueMachineIdRequestPacketHandler
import com.habbokt.packet.dasm.handshake.uniquemachineid.UniqueMachineIdRequestProxyPacket
import com.habbokt.packet.dasm.handshake.uniquemachineid.UniqueMachineIdRequestProxyPacketHandler
import com.habbokt.packet.dasm.handshake.versioncheck.VersionCheckPacket
import com.habbokt.packet.dasm.handshake.versioncheck.VersionCheckPacketDisassembler
import com.habbokt.packet.dasm.handshake.versioncheck.VersionCheckPacketHandler
import com.habbokt.packet.dasm.handshake.versioncheck.VersionCheckProxyPacket
import com.habbokt.packet.dasm.handshake.versioncheck.VersionCheckProxyPacketHandler
import com.habbokt.packet.dasm.navigator.navigate.NavigatePacket
import com.habbokt.packet.dasm.navigator.navigate.NavigatePacketDisassembler
import com.habbokt.packet.dasm.navigator.navigate.NavigatePacketHandler
import com.habbokt.packet.dasm.navigator.navigate.NavigateProxyPacket
import com.habbokt.packet.dasm.navigator.navigate.NavigateProxyPacketHandler
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
        assemblers.addBinding(UniqueMachineIdResponsePacket::class).to<UniqueMachineIdResponsePacketAssembler>()
        assemblers.addBinding(SessionParametersResponsePacket::class).to<SessionParametersResponsePacketAssembler>()
        assemblers.addBinding(UserRightsPacket::class).to<UserRightsPacketAssembler>()
        assemblers.addBinding(AuthenticationOKPacket::class).to<AuthenticationOKPacketAssembler>()
        assemblers.addBinding(ScrSendUserInfoPacket::class).to<ScrSendUserInfoPacketAssembler>()
        assemblers.addBinding(UserObjectPacket::class).to<UserObjectPacketAssembler>()
        assemblers.addBinding(NavNodeInfoPacket::class).to<NavNodeInfoPacketAssembler>()

        // Disassemblers
        val disassemblers = KotlinMapBinder.newMapBinder<Int, PacketDisassembler>(kotlinBinder)
        disassemblers.addBinding(206).to<InitDiffieHandshakePacketDisassembler>()
        disassemblers.addBinding(2002).to<CompleteDiffieHandshakeRequestPacketDisassembler>()
        disassemblers.addBinding(1170).to<VersionCheckPacketDisassembler>()
        disassemblers.addBinding(813).to<UniqueMachineIdRequestPacketDisassembler>()
        disassemblers.addBinding(1817).to<SessionParametersRequestPacketDisassembler>()
        disassemblers.addBinding(204).to<SSOTicketPacketDisassembler>()
        disassemblers.addBinding(26).to<ScrGetUserInfoPacketDisassembler>()
        disassemblers.addBinding(7).to<InfoRetrievePacketDisassembler>()
        disassemblers.addBinding(150).to<NavigatePacketDisassembler>()

        // Proxies
        val proxies = KotlinMapBinder.newMapBinder<KClass<*>, ProxyPacketHandler<Packet>>(kotlinBinder)
        proxies.addBinding(InfoRetrievePacket::class).to<InfoRetrieveProxyPacketHandler>()
        proxies.addBinding(CompleteDiffieHandshakeRequestPacket::class).to<CompleteDiffieHandshakeRequestProxyPacketHandler>()
        proxies.addBinding(InitDiffieHandshakeRequestPacket::class).to<InitDiffieHandshakeRequestProxyPacketHandler>()
        proxies.addBinding(SSOTicketPacket::class).to<SSOTicketProxyPacketHandler>()
        proxies.addBinding(VersionCheckPacket::class).to<VersionCheckProxyPacketHandler>()
        proxies.addBinding(SessionParametersRequestPacket::class).to<SessionParametersRequestProxyPacketHandler>()
        proxies.addBinding(ScrGetUserInfoPacket::class).to<ScrGetUserInfoProxyPacketHandler>()
        proxies.addBinding(UniqueMachineIdRequestPacket::class).to<UniqueMachineIdRequestProxyPacketHandler>()
        proxies.addBinding(NavigatePacket::class).to<NavigateProxyPacketHandler>()

        // Handlers
        val handlers = KotlinMapBinder.newMapBinder<KClass<*>, PacketHandler<ProxyPacket>>(kotlinBinder)
        handlers.addBinding(InfoRetrieveProxyPacket::class).to<InfoRetrievePacketHandler>()
        handlers.addBinding(CompleteDiffieHandshakeRequestProxyPacket::class).to<CompleteDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding(InitDiffieHandshakeRequestProxyPacket::class).to<InitDiffieHandshakeRequestPacketHandler>()
        handlers.addBinding(SSOTicketProxyPacket::class).to<SSOTicketPacketHandler>()
        handlers.addBinding(VersionCheckProxyPacket::class).to<VersionCheckPacketHandler>()
        handlers.addBinding(SessionParametersRequestProxyPacket::class).to<SessionParametersRequestPacketHandler>()
        handlers.addBinding(ScrGetUserInfoProxyPacket::class).to<ScrGetUserInfoPacketHandler>()
        handlers.addBinding(UniqueMachineIdRequestProxyPacket::class).to<UniqueMachineIdRequestPacketHandler>()
        handlers.addBinding(NavigateProxyPacket::class).to<NavigatePacketHandler>()
    }
}