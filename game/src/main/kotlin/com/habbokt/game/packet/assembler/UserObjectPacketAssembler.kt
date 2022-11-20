package com.habbokt.game.packet.assembler

import com.habbokt.api.buffer.*
import com.habbokt.api.packet.*
import com.habbokt.api.packet.assembler.*

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