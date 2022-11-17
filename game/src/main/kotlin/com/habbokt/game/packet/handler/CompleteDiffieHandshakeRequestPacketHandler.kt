package com.habbokt.game.packet.handler

import com.habbokt.game.packet.CompleteDiffieHandshakeRequestPacket
import com.habbokt.game.packet.CompleteDiffieHandshakeResponsePacket
import com.habbokt.game.uuid

/**
 * @author Jordan Abraham
 */
fun PacketHandlerListener.completeDiffieHandshakePacket() {
    handlePacket<CompleteDiffieHandshakeRequestPacket> {
        client.writePacket(
            CompleteDiffieHandshakeResponsePacket(
                secretKey = uuid(32)
            )
        )
    }
}