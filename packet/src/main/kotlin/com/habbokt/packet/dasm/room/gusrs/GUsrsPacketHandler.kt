package com.habbokt.packet.dasm.room.gusrs

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.activeobjects.ActiveObjectsPacket
import com.habbokt.packet.asm.room.objects.ObjectsPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GUsrsPacketHandler : PacketHandler<GUsrsProxyPacket>(Handler {
    it.writePacket(ObjectsPacket(emptyList()))
    it.writePacket(ActiveObjectsPacket(emptyList()))
})