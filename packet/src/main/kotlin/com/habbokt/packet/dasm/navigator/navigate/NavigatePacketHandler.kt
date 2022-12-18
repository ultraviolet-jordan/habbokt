package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.api.room.Room
import com.habbokt.api.room.RoomCategory
import com.habbokt.api.room.RoomSubCategory
import com.habbokt.packet.asm.navigater.navnodeinfo.NavNodeInfoPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigatePacketHandler : PacketHandler<NavigateProxyPacket>(Handler {
    // TODO Some sort of real rooms system.
    val rooms = this.rooms.map { room ->
        Room(
            id = room.id,
            port = room.id + 1000,
            name = room.name,
            userCount = 4,
            maxUsers = 50,
            parentId = room.categoryId,
            description = room.description,
            door = 0, // No password
            swfCast = room.swfCast,
            usersInQueue = 0,
            visible = true,
            owner = "jordan"
        )
    }

    val subCategories = this.subCategories.map { subCategory ->
        RoomSubCategory(
            id = subCategory.id,
            parentId = subCategory.parentId,
            name = subCategory.name
        )
    }

    it.writePacket(NavNodeInfoPacket(
        mask = hideFullRooms.toInt(),
        category = RoomCategory(
            id = category.id,
            parentId = category.parentId,
            name = category.name,
            public = category.id != 4, // Category 4 is guest category.
            rooms = rooms
        ),
        subCategories = subCategories
    ))
})