package com.habbokt.packet.asm.navigater.navnodeinfo

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.api.room.Room
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo
import java.nio.ByteBuffer

/**
 * @author Jordan Abraham
 */
@Singleton
class NavNodeInfoPacketAssembler : PacketAssembler<NavNodeInfoPacket>(
    id = 220,
    body = {
        require(it.mask == 0 || it.mask == 1)

        val (id, parentId, name, public, rooms) = it.category
        putIntHabbo(it.mask) // This is for showing/hiding full rooms.
        putCategory(id, if (public) 0 else 2, name, parentId) // Create the root category that was clicked.
        // Send rooms associated with this clicked category.
        if (public) {
            putPublicRooms(rooms)
            // Send sub categories below the rooms that the user can click into.
            it.subCategories.forEach { subCategory ->
                putCategory(subCategory.id, 0, subCategory.name, id)
            }
        } else {
            putGuestRooms(rooms)
        }
        // Terminate the packet loop on the client side.
        putIntHabbo(0) // Break
    }
)

private fun ByteBuffer.putInfo(
    id: Int,
    type: Int,
    name: String,
    userCount: Int,
    maxUsers: Int,
    parentId: Int
) {
    putIntHabbo(id)
    putIntHabbo(type)
    putStringHabbo(name)
    putIntHabbo(userCount)
    putIntHabbo(maxUsers)
    putIntHabbo(parentId)
}

private fun ByteBuffer.putCategory(id: Int, type: Int, name: String, parentId: Int) {
    require(type == 0 || type == 2) // 0 for public, 2 for guest.
    putInfo(id, type, name, 0, 0, parentId)
}

private fun ByteBuffer.putPublicRooms(rooms: List<Room>) {
    rooms.forEach {
        putInfo(it.port, 1, it.name, it.userCount, it.maxUsers, it.parentId)
        putStringHabbo(it.description)
        putIntHabbo(it.id) // 1
        putIntHabbo(it.door) // Password
        putStringHabbo(it.swfCast)
        putIntHabbo(it.usersInQueue)
        putIntHabbo(it.visible.toInt())
    }
}

private fun ByteBuffer.putGuestRooms(rooms: List<Room>) {
    putIntHabbo(rooms.size)
    rooms.forEach {
        putIntHabbo(it.id) // 1
        putStringHabbo(it.name)
        putStringHabbo(it.owner)
        putStringHabbo("open") // Password
        putIntHabbo(it.userCount)
        putIntHabbo(it.maxUsers)
        putStringHabbo(it.description)
    }
}