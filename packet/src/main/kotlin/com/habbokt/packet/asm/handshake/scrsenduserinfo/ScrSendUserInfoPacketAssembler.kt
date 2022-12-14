package com.habbokt.packet.asm.handshake.scrsenduserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.Assembler
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrSendUserInfoPacketAssembler : PacketAssembler<ScrSendUserInfoPacket>(Assembler(id = 7) {
    it.putStringHabbo(productName)
    it.putIntHabbo(daysLeft)
    it.putIntHabbo(elapsedPeriods)
    it.putIntHabbo(prepaidPeriods)
    it.putIntHabbo(responseFlag)
})