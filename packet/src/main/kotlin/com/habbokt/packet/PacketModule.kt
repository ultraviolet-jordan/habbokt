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
import com.habbokt.packet.asm.room.flatproperty.FlatPropertyPacket
import com.habbokt.packet.asm.room.flatproperty.FlatPropertyPacketAssembler
import com.habbokt.packet.asm.room.floormap.FloorMapPacket
import com.habbokt.packet.asm.room.floormap.FloorMapPacketAssembler
import com.habbokt.packet.asm.room.interstitialdata.InterstitialDataPacket
import com.habbokt.packet.asm.room.interstitialdata.InterstitialDataPacketAssembler
import com.habbokt.packet.asm.room.roomad.RoomAdPacket
import com.habbokt.packet.asm.room.roomad.RoomAdPacketAssembler
import com.habbokt.packet.asm.room.roomready.RoomReadyPacket
import com.habbokt.packet.asm.room.roomready.RoomReadyPacketAssembler
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
import com.habbokt.packet.dasm.room.getfloormap.GetFloorMapPacket
import com.habbokt.packet.dasm.room.getfloormap.GetFloorMapPacketDisassembler
import com.habbokt.packet.dasm.room.getfloormap.GetFloorMapPacketHandler
import com.habbokt.packet.dasm.room.getfloormap.GetFloorMapProxyPacket
import com.habbokt.packet.dasm.room.getfloormap.GetFloorMapProxyPacketHandler
import com.habbokt.packet.dasm.room.getinterst.GetInterstPacket
import com.habbokt.packet.dasm.room.getinterst.GetInterstPacketDisassembler
import com.habbokt.packet.dasm.room.getinterst.GetInterstPacketHandler
import com.habbokt.packet.dasm.room.getinterst.GetInterstProxyPacket
import com.habbokt.packet.dasm.room.getinterst.GetInterstProxyPacketHandler
import com.habbokt.packet.dasm.room.getroomad.GetRoomAdPacket
import com.habbokt.packet.dasm.room.getroomad.GetRoomAdPacketDisassembler
import com.habbokt.packet.dasm.room.getroomad.GetRoomAdPacketHandler
import com.habbokt.packet.dasm.room.getroomad.GetRoomAdProxyPacket
import com.habbokt.packet.dasm.room.getroomad.GetRoomAdProxyPacketHandler
import com.habbokt.packet.dasm.room.roomdirectory.RoomDirectoryPacket
import com.habbokt.packet.dasm.room.roomdirectory.RoomDirectoryPacketDisassembler
import com.habbokt.packet.dasm.room.roomdirectory.RoomDirectoryPacketHandler
import com.habbokt.packet.dasm.room.roomdirectory.RoomDirectoryProxyPacket
import com.habbokt.packet.dasm.room.roomdirectory.RoomDirectoryProxyPacketHandler
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.multibindings.KotlinMapBinder
import kotlin.reflect.KClass

/**
 * @author Jordan Abraham
 */
object PacketModule : KotlinModule() {
    override fun configure() {
        install(DAOModule)
        bindAssemblers()
        bindDisassemblers()
        bindProxyHandlers()
        bindHandlers()
    }

    private fun bindAssemblers() {
        KotlinMapBinder.newMapBinder<KClass<*>, PacketAssembler<Packet>>(kotlinBinder).apply {
            bindAssembler<ClientHelloPacket, ClientHelloPacketAssembler>()
            bindAssembler<InitDiffieHandshakeResponsePacket, InitDiffieHandshakeResponsePacketAssembler>()
            bindAssembler<CompleteDiffieHandshakeResponsePacket, CompleteDiffieHandshakeResponsePacketAssembler>()
            bindAssembler<DisconnectReasonPacket, DisconnectReasonPacketAssembler>()
            bindAssembler<UniqueMachineIdResponsePacket, UniqueMachineIdResponsePacketAssembler>()
            bindAssembler<SessionParametersResponsePacket, SessionParametersResponsePacketAssembler>()
            bindAssembler<UserRightsPacket, UserRightsPacketAssembler>()
            bindAssembler<AuthenticationOKPacket, AuthenticationOKPacketAssembler>()
            bindAssembler<ScrSendUserInfoPacket, ScrSendUserInfoPacketAssembler>()
            bindAssembler<UserObjectPacket, UserObjectPacketAssembler>()
            bindAssembler<NavNodeInfoPacket, NavNodeInfoPacketAssembler>()
            bindAssembler<InterstitialDataPacket, InterstitialDataPacketAssembler>()
            bindAssembler<RoomReadyPacket, RoomReadyPacketAssembler>()
            bindAssembler<FlatPropertyPacket, FlatPropertyPacketAssembler>()
            bindAssembler<RoomAdPacket, RoomAdPacketAssembler>()
            bindAssembler<FloorMapPacket, FloorMapPacketAssembler>()
        }
    }

    private fun bindDisassemblers() {
        KotlinMapBinder.newMapBinder<Int, PacketDisassembler>(kotlinBinder).apply {
            bindDisassembler<InitDiffieHandshakePacketDisassembler>(id = 206)
            bindDisassembler<CompleteDiffieHandshakeRequestPacketDisassembler>(id = 2002)
            bindDisassembler<VersionCheckPacketDisassembler>(id = 1170)
            bindDisassembler<UniqueMachineIdRequestPacketDisassembler>(id = 813)
            bindDisassembler<SessionParametersRequestPacketDisassembler>(id = 1817)
            bindDisassembler<SSOTicketPacketDisassembler>(id = 204)
            bindDisassembler<ScrGetUserInfoPacketDisassembler>(id = 26)
            bindDisassembler<InfoRetrievePacketDisassembler>(id = 7)
            bindDisassembler<NavigatePacketDisassembler>(id = 150)
            bindDisassembler<GetInterstPacketDisassembler>(id = 182)
            bindDisassembler<RoomDirectoryPacketDisassembler>(id = 2)
            bindDisassembler<GetRoomAdPacketDisassembler>(id = 126)
            bindDisassembler<GetFloorMapPacketDisassembler>(id = 394)
        }
    }

    private fun bindProxyHandlers() {
        KotlinMapBinder.newMapBinder<KClass<*>, ProxyPacketHandler<Packet>>(kotlinBinder).apply {
            bindProxyHandler<InfoRetrievePacket, InfoRetrieveProxyPacketHandler>()
            bindProxyHandler<CompleteDiffieHandshakeRequestPacket, CompleteDiffieHandshakeRequestProxyPacketHandler>()
            bindProxyHandler<InitDiffieHandshakeRequestPacket, InitDiffieHandshakeRequestProxyPacketHandler>()
            bindProxyHandler<SSOTicketPacket, SSOTicketProxyPacketHandler>()
            bindProxyHandler<VersionCheckPacket, VersionCheckProxyPacketHandler>()
            bindProxyHandler<SessionParametersRequestPacket, SessionParametersRequestProxyPacketHandler>()
            bindProxyHandler<ScrGetUserInfoPacket, ScrGetUserInfoProxyPacketHandler>()
            bindProxyHandler<UniqueMachineIdRequestPacket, UniqueMachineIdRequestProxyPacketHandler>()
            bindProxyHandler<NavigatePacket, NavigateProxyPacketHandler>()
            bindProxyHandler<GetInterstPacket, GetInterstProxyPacketHandler>()
            bindProxyHandler<RoomDirectoryPacket, RoomDirectoryProxyPacketHandler>()
            bindProxyHandler<GetRoomAdPacket, GetRoomAdProxyPacketHandler>()
            bindProxyHandler<GetFloorMapPacket, GetFloorMapProxyPacketHandler>()
        }
    }

    private fun bindHandlers() {
        KotlinMapBinder.newMapBinder<KClass<*>, PacketHandler<ProxyPacket>>(kotlinBinder).apply {
            bindHandler<InfoRetrieveProxyPacket, InfoRetrievePacketHandler>()
            bindHandler<CompleteDiffieHandshakeRequestProxyPacket, CompleteDiffieHandshakeRequestPacketHandler>()
            bindHandler<InitDiffieHandshakeRequestProxyPacket, InitDiffieHandshakeRequestPacketHandler>()
            bindHandler<SSOTicketProxyPacket, SSOTicketPacketHandler>()
            bindHandler<VersionCheckProxyPacket, VersionCheckPacketHandler>()
            bindHandler<SessionParametersRequestProxyPacket, SessionParametersRequestPacketHandler>()
            bindHandler<ScrGetUserInfoProxyPacket, ScrGetUserInfoPacketHandler>()
            bindHandler<UniqueMachineIdRequestProxyPacket, UniqueMachineIdRequestPacketHandler>()
            bindHandler<NavigateProxyPacket, NavigatePacketHandler>()
            bindHandler<GetInterstProxyPacket, GetInterstPacketHandler>()
            bindHandler<RoomDirectoryProxyPacket, RoomDirectoryPacketHandler>()
            bindHandler<GetRoomAdProxyPacket, GetRoomAdPacketHandler>()
            bindHandler<GetFloorMapProxyPacket, GetFloorMapPacketHandler>()
        }
    }

    private inline fun <reified T : Packet, reified X: PacketAssembler<T>> KotlinMapBinder<KClass<*>, PacketAssembler<Packet>>.bindAssembler() {
        addBinding(T::class).to<X>()
    }

    private inline fun <reified X: PacketDisassembler> KotlinMapBinder<Int, PacketDisassembler>.bindDisassembler(id: Int) {
        addBinding(id).to<X>()
    }

    private inline fun <reified T : Packet, reified X: ProxyPacketHandler<T>> KotlinMapBinder<KClass<*>, ProxyPacketHandler<Packet>>.bindProxyHandler() {
        addBinding(T::class).to<X>()
    }

    private inline fun <reified T : ProxyPacket, reified X: PacketHandler<T>> KotlinMapBinder<KClass<*>, PacketHandler<ProxyPacket>>.bindHandler() {
        addBinding(T::class).to<X>()
    }
}