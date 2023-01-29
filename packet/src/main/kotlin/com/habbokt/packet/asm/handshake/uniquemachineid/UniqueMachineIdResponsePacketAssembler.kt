package com.habbokt.packet.asm.handshake.uniquemachineid

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdResponsePacketAssembler : PacketAssembler<UniqueMachineIdResponsePacket>(
    id = 439,
    body = {
        putStringHabbo(it.machineId)
    }
)