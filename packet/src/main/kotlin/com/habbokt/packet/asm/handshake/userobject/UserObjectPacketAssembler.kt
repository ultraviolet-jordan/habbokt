package com.habbokt.packet.asm.handshake.userobject

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketAssembler
import com.habbokt.packet.buf.putIntHabbo
import com.habbokt.packet.buf.putStringHabbo

/**
 * @author Jordan Abraham
 */
@Singleton
class UserObjectPacketAssembler : PacketAssembler<UserObjectPacket>(
    id = 5,
    body = {
        putStringHabbo(it.userId)
        putStringHabbo(it.name)
        putStringHabbo(it.figure)
        putStringHabbo(it.sex)
        putStringHabbo(it.customData)
        putIntHabbo(it.phTickets)
        putStringHabbo(it.phFigure)
        putIntHabbo(it.photoFilm)
        putIntHabbo(it.directMail)
        putIntHabbo(it.respectTicketTotal)
        putIntHabbo(it.respectTicketCount)
    }
)