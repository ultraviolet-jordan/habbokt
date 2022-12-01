package com.habbokt.swf

import com.flagstone.transform.Movie
import com.habbokt.swf.avatarsbig.AvatarsBigSwf
import com.habbokt.swf.badgeeditor.BadgeEditorSwf
import com.habbokt.swf.habboregistration.HabboRegistrationSwf
import dev.misfitlabs.kotlinguice4.KotlinModule
import java.io.File

/**
 * @author Jordan Abraham
 */
object SwfModule : KotlinModule() {
    override fun configure() {
        val avatarBigSwfMovie = Movie().apply {
            decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/avatars_big.swf")!!.toURI()))
        }
        bind<AvatarsBigSwf>().toInstance(AvatarsBigSwf(avatarBigSwfMovie))

        val habboRegistrationSwfMovie = Movie().apply {
            decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/HabboRegistration.swf")!!.toURI()))
        }
        bind<HabboRegistrationSwf>().toInstance(HabboRegistrationSwf(habboRegistrationSwfMovie))

        val badgeEditorSwfMovie = Movie().apply {
            decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/BadgeEditor.swf")!!.toURI()))
        }
        bind<BadgeEditorSwf>().toInstance(BadgeEditorSwf(badgeEditorSwfMovie))
    }
}