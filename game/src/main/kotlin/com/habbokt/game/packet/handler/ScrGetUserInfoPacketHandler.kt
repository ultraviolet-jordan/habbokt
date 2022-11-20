package com.habbokt.game.packet.handler

import com.habbokt.api.packet.ScrGetUserInfoPacket
import com.habbokt.api.packet.ScrSendUserInfoPacket
import com.habbokt.api.packet.handler.handler

/**
 * @author Jordan Abraham
 */
val ScrGetUserInfoPacketHandler = handler<ScrGetUserInfoPacket> {
    if (packet.productName == "club_habbo") {
        client.writePacket(ScrSendUserInfoPacket(
            productName = packet.productName, // "club_habbo"
            daysLeft = 0,
            elapsedPeriods = 0,
            prepaidPeriods = 0,
            responseFlag = 1 // The Habbo club dialogue opens when set to 2.
        ))
    }
}