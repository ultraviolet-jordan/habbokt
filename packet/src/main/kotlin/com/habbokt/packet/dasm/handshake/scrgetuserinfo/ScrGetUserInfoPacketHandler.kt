package com.habbokt.packet.dasm.handshake.scrgetuserinfo

import com.google.inject.Singleton
import com.habbokt.api.packet.PacketHandler
import com.habbokt.packet.asm.handshake.scrsenduserinfo.ScrSendUserInfoPacket

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoPacketHandler : PacketHandler<ScrGetUserInfoProxyPacket>(
    handler = {
        if (it.productName == "club_habbo") {
            writePacket(
                ScrSendUserInfoPacket(
                    productName = it.productName, // "club_habbo"
                    daysLeft = 0,
                    elapsedPeriods = 0,
                    prepaidPeriods = 0,
                    responseFlag = 1 // The Habbo club dialogue opens when set to 2.
                )
            )
        }
    }
)