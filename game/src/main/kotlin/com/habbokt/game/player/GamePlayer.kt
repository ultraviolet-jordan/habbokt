package com.habbokt.game.player

import com.habbokt.api.client.handshake.LoginInformation
import com.habbokt.api.player.Player

/**
 * @author Jordan Abraham
 */
class GamePlayer(
    private val id: Int,
    private val username: String
) : Player {
    private lateinit var password: String
    private lateinit var email: String
    private lateinit var appearance: String
    private lateinit var gender: String

    override fun id(): Int = id
    override fun username(): String = username
    override fun password(): String = password
    override fun email(): String = email
    override fun appearance(): String = appearance
    override fun gender(): String = gender

    override fun validateLogin(information: LoginInformation): Player? {
        this.password = information.password
        this.email = information.email
        this.appearance = information.appearance
        this.gender = information.gender
        return if (password.isEmpty() || email.isEmpty() || appearance.isEmpty() || gender.isEmpty()) null else this
    }
}