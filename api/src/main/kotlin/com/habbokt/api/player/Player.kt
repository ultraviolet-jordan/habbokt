package com.habbokt.api.player

import com.habbokt.api.client.handshake.LoginInformation

/**
 * @author Jordan Abraham
 */
interface Player {
    fun id(): Int
    fun username(): String
    fun password(): String
    fun email(): String
    fun appearance(): String
    fun gender(): String
    fun validateLogin(information: LoginInformation): Player?
}