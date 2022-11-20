package com.habbokt.game.player

import com.habbokt.api.player.Player

/**
 * @author Jordan Abraham
 */
class GamePlayer(
    private val id: Int,
    private val username: String,
    private val password: String,
    private val email: String,
    private val appearance: String,
    private val gender: String,
) : Player {
    override fun id(): Int = id
    override fun username(): String = username
    override fun password(): String = password
    override fun email(): String = email
    override fun appearance(): String = appearance
    override fun gender(): String = gender
}