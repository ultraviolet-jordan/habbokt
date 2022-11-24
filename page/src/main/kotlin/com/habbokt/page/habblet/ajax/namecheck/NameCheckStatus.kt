package com.habbokt.page.habblet.ajax.namecheck

/**
 * @author Jordan Abraham
 */
sealed class NameCheckStatus(
    val string: String
) {
    object Successful : NameCheckStatus("")
    object NameTaken : NameCheckStatus("A user with this name already exists.")
    object Empty : NameCheckStatus("Please enter a username.")
    object TooLong : NameCheckStatus("The name you have chosen is too long.")
    object NotAllowed : NameCheckStatus("This name is not allowed.")
    object Invalid : NameCheckStatus("Your username is invalid or contains invalid characters.")
    object Unacceptable : NameCheckStatus("This name is unacceptable to hotel management.")
}