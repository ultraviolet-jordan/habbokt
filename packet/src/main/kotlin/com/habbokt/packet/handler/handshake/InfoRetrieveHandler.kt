package com.habbokt.packet.handler.handshake

import com.google.inject.Singleton
import com.habbokt.packet.InfoRetrievePacket
import com.habbokt.packet.handler.Handler
import com.habbokt.packet.handler.HandlerListener

/**
 * @author Jordan Abraham
 */
@Singleton
class InfoRetrieveHandler : HandlerListener<InfoRetrievePacket>(Handler {

})