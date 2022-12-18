package com.habbokt.packet.dasm.room.getinterst

import com.google.inject.Singleton
import com.habbokt.api.packet.Handler
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.room.interstitialdata.InterstitialDataPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class GetInterstPacketHandler : PacketHandler<GetInterstProxyPacket>(Handler {
    if (parameter == "general") {
        it.writePacket(InterstitialDataPacket.Empty)
    }
})