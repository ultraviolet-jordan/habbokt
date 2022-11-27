package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.UniqueMachineIdPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener
import java.util.UUID

/**
 * @author Jordan Abraham
 */
@Singleton
class UniqueMachineIdHandler : HandlerListener<UniqueMachineIdPacket>(Handler {
    val id = if (machineId.isEmpty() || (machineId.length != 33) || (machineId[0] != '#')) "#${UUID.randomUUID().toString().uppercase().replace("-", "")}"
    else machineId

    // TODO Store this machineId somewhere.
    it.writePacket(UniqueMachineIdPacket(id))
})