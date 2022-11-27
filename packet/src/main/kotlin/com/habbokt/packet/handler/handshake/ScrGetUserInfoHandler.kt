package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.ScrGetUserInfoPacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class ScrGetUserInfoHandler : HandlerListener<ScrGetUserInfoPacket>(Handler {
    if (productName == "club_habbo") {

    }
})