package com.habbokt.game

import com.habbokt.api.client.Client
import com.habbokt.api.entity.player.Player
import com.habbokt.api.entity.player.PlayerDetails
import com.habbokt.packet.AuthenticationOKPacket
import com.habbokt.packet.UserRightsPacket

/**
 * @author Jordan Abraham
 */
class GamePlayer(
    client: Client,
    details: PlayerDetails
) : Player(client, details) {
    override fun login() {
        client.writePacket(UserRightsPacket())
        client.writePacket(AuthenticationOKPacket())
    }
}