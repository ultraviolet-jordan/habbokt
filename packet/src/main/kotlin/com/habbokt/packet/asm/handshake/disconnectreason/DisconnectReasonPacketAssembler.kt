package com.habbokt.packet.asm.handshake.disconnectreason

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class DisconnectReasonPacketAssembler : PacketAssembler<DisconnectReasonPacket>(
    id = 287,
    body = {
        putIntHabbo(it.reason)
    }
)