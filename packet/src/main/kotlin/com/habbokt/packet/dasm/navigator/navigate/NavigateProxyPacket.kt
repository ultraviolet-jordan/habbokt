package com.habbokt.packet.dasm.navigator.navigate

import com.habbokt.api.packet.ProxyPacket
import com.habbokt.api.room.Room
import com.habbokt.dao.rooms.categories.RoomCategoryDAO

/**
 * @author Jordan Abraham
 */
data class NavigateProxyPacket(
    val hideFullRooms: Boolean,
    val category: RoomCategoryDAO,
    val rooms: List<Room>
) : ProxyPacket