package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ScrGetUserInfoPacket
import com.habbokt.packet.ScrSendUserInfoPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.PacketHandler

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoPacketHandler : PacketHandler<ScrGetUserInfoPacket>(Handler {
    if (productName == "club_habbo") {
        it.writePacket(
            ScrSendUserInfoPacket(
                productName = productName, // "club_habbo"
                daysLeft = 0,
                elapsedPeriods = 0,
                prepaidPeriods = 0,
                responseFlag = 1 // The Habbo club dialogue opens when set to 2.
            )
        )
    }
})