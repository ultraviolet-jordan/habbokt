package com.habbokt.packet.dasm.handshake.sessionparameters

import com.habbokt.api.packet.Packet

/**
 * @author Jordan Abraham
 */
class SessionParametersRequestPacket : Packet {
    companion object {
        val Empty = SessionParametersRequestPacket()
    }
}