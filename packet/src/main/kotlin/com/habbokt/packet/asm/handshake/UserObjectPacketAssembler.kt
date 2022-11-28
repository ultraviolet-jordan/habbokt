package com.habbokt.packet.asm.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UserObjectPacket
import com.habbokt.packet.asm.Assembler
import com.habbokt.packet.asm.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UserObjectPacketAssembler : PacketAssembler<UserObjectPacket>(Assembler(id = 5) {
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
})