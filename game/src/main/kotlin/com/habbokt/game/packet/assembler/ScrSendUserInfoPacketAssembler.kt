package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.*
import com.habbokt.api.packet.*
import com.habbokt.api.packet.assembler.*

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