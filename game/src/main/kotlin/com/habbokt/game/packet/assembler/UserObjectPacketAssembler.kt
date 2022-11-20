package com.habbokt.game.packet.assembler

import com.habbokt.api.common.putIntHabbo
import com.habbokt.api.common.putStringHabbo
import com.habbokt.api.packet.UserObjectPacket
import com.habbokt.api.packet.assembler.assembler

/**
 * @author Jordan Abraham
 */
val UserObjectPacketAssembler = assembler<UserObjectPacket>(id = 5) {
    it.putStringHabbo(userId)
    it.putStringHabbo(name)
    it.putStringHabbo(figure)
    it.putStringHabbo(sex)
    it.putStringHabbo(customData)
    it.putIntHabbo(phTickets)
    it.putStringHabbo(phFigure)
    it.putIntHabbo(photoFilm)
    it.putIntHabbo(directMail)
    it.putIntHabbo(respectTicketTotal)
    it.putIntHabbo(respectTicketCount)
}