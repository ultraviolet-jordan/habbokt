package com.habbokt.packet.asm.handshake.scrsenduserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrSendUserInfoPacketAssembler : PacketAssembler<ScrSendUserInfoPacket>(
    id = 7,
    body = {
        putStringHabbo(it.productName)
        putIntHabbo(it.daysLeft)
        putIntHabbo(it.elapsedPeriods)
        putIntHabbo(it.prepaidPeriods)
        putIntHabbo(it.responseFlag)
    }
)