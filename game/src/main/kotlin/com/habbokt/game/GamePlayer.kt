package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.packet.AuthenticationOKPacket
import com.habbokt.packet.UserRightsPacket

/**
 * @author Jordan Abraham
 */
class GamePlayer(
    id: Int,
    client: Client
) : Player(id, client) {
    override fun login() {
        client.writePacket(UserRightsPacket())
        client.writePacket(AuthenticationOKPacket())
    }
}