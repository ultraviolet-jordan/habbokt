package com.habbokt.swf

import com.google.inject.Provider
import com.habbokt.swf.avatarsbig.AvatarsBigSwf
import com.habbokt.swf.avatarsbig.AvatarsBigSwfMovie
import com.habbokt.swf.avatarsbig.AvatarsBigSwfMovieProvider
import com.habbokt.swf.avatarsbig.AvatarsBigSwfProvider
import com.habbokt.swf.badgeeditor.BadgeEditorSwf
import com.habbokt.swf.badgeeditor.BadgeEditorSwfMovie
import com.habbokt.swf.badgeeditor.BadgeEditorSwfMovieProvider
import com.habbokt.swf.badgeeditor.BadgeEditorSwfProvider
import com.habbokt.swf.figuredata.humanbody.HumanBodySwf
import com.habbokt.swf.figuredata.humanbody.HumanBodySwfMovie
import com.habbokt.swf.figuredata.humanbody.HumanBodySwfMovieProvider
import com.habbokt.swf.figuredata.humanbody.HumanBodySwfProvider
import com.habbokt.swf.habboregistration.HabboRegistrationSwf
import com.habbokt.swf.habboregistration.HabboRegistrationSwfMovie
import com.habbokt.swf.habboregistration.HabboRegistrationSwfMovieProvider
import com.habbokt.swf.habboregistration.HabboRegistrationSwfProvider
import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
object SwfModule : KotlinModule() {
    override fun configure() {
        bindProvider<AvatarsBigSwfMovie, AvatarsBigSwfMovieProvider>()
        bindProvider<AvatarsBigSwf, AvatarsBigSwfProvider>()

        bindProvider<BadgeEditorSwfMovie, BadgeEditorSwfMovieProvider>()
        bindProvider<BadgeEditorSwf, BadgeEditorSwfProvider>()

        bindProvider<HabboRegistrationSwfMovie, HabboRegistrationSwfMovieProvider>()
        bindProvider<HabboRegistrationSwf, HabboRegistrationSwfProvider>()

        bindProvider<HumanBodySwfMovie, HumanBodySwfMovieProvider>()
        bindProvider<HumanBodySwf, HumanBodySwfProvider>()
    }

    private inline fun <reified T, reified P : Provider<T>> bindProvider() {
        bind<T>().toProvider<P>()
    }
}