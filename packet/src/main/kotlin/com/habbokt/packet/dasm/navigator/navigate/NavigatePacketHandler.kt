package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.navigater.navnodeinfo.NavNodeInfoPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigatePacketHandler : PacketHandler<NavigateProxyPacket>(Handler {
    it.writePacket(NavNodeInfoPacket(
        mask = hideFullRooms.toInt(),
        id = category.id,
        type = 0, // 0 for public.
        name = category.name,
        userCount = 0,
        maxUsers = 10,
        parentId = category.parentRoomId,
        rooms = rooms
    ))
})