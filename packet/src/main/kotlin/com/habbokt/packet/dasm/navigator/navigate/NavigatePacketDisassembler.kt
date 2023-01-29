package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigatePacketDisassembler : PacketDisassembler<NavigatePacket>(
    body = {
        NavigatePacket(
            mask = getIntHabbo(),
            id = getIntHabbo(),
            depth = getIntHabbo()
        )
    }
)