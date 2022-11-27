package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ScrSendUserInfoPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.AssemblerListener
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrSendUserInfoAssembler : AssemblerListener<ScrSendUserInfoPacket>(Assembler(id = 7) {
    it.putStringHabbo(productName)
    it.putIntHabbo(daysLeft)
    it.putIntHabbo(elapsedPeriods)
    it.putIntHabbo(prepaidPeriods)
    it.putIntHabbo(responseFlag)
})