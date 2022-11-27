package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ScrGetUserInfoPacket
import com.habbokt.packet.ScrSendUserInfoPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoHandler : HandlerListener<ScrGetUserInfoPacket>(Handler {
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