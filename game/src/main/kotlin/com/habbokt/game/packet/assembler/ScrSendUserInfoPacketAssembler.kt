package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putIntHabbo
import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.packet.ScrSendUserInfoPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val ScrSendUserInfoPacketAssembler = assembler<ScrSendUserInfoPacket>(id = 7) {
    it.putStringHabbo(productName)
    it.putIntHabbo(daysLeft)
    it.putIntHabbo(elapsedPeriods)
    it.putIntHabbo(prepaidPeriods)
    it.putIntHabbo(responseFlag)
}