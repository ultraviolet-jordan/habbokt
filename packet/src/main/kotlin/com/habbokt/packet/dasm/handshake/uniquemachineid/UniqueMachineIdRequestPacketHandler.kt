package com.habbokt.packet.dasm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.uniquemachineid.UniqueMachineIdResponsePacket

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdRequestPacketHandler : PacketHandler<UniqueMachineIdRequestProxyPacket>(Handler {
    it.writePacket(UniqueMachineIdResponsePacket(machineId))
})