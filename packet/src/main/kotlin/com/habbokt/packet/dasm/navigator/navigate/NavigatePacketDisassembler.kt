package com.habbokt.packet.dasm.navigator.navigate

import com.google.inject.Singleton
import com.habbokt.api.packet.Disassembler
import com.habbokt.api.packet.PacketDisassembler
import com.habbokt.packet.buf.getIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class NavigatePacketDisassembler : PacketDisassembler(Disassembler {
    NavigatePacket(
        mask = it.getIntHabbo(),
        id = it.getIntHabbo(),
        depth = it.getIntHabbo()
    )
})