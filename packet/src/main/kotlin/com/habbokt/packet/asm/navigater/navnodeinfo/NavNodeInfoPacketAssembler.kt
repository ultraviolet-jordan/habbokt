package com.habbokt.packet.asm.navigater.navnodeinfo

import com.google.inject.Singleton
import com.habbokt.api.common.toInt
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class NavNodeInfoPacketAssembler : PacketAssembler<NavNodeInfoPacket>(Assembler(id = 220) {
    it.putIntHabbo(mask)
    it.putIntHabbo(id)
    it.putIntHabbo(type)
    it.putStringHabbo(name)
    it.putIntHabbo(userCount)
    it.putIntHabbo(maxUsers)
    it.putIntHabbo(parentId)
    rooms.forEach { room ->
        it.putIntHabbo(room.port) // 1001
        it.putIntHabbo(room.type) // 1
        it.putStringHabbo(room.name)
        it.putIntHabbo(room.userCount)
        it.putIntHabbo(room.maxUsers)
        it.putIntHabbo(room.parentId)
        it.putStringHabbo(room.description)
        it.putIntHabbo(room.port) // 1001
        it.putIntHabbo(room.door) // Password
        it.putStringHabbo(room.swfCast)
        it.putIntHabbo(room.usersInQueue)
        it.putIntHabbo(room.visible.toInt())
    }
})