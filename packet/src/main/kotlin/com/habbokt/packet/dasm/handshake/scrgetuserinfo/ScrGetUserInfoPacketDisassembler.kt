package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoPacketDisassembler : PacketDisassembler<ScrGetUserInfoPacket>(
    body = {
        ScrGetUserInfoPacket(
            productName = getStringHabbo()
        )
    }
)