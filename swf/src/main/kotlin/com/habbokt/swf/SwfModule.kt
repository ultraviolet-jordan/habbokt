package com.habbokt.swf

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
        // Avatars big swf.
        bind<AvatarsBigSwfMovie>().toProvider<AvatarsBigSwfMovieProvider>()
        bind<AvatarsBigSwf>().toProvider<AvatarsBigSwfProvider>()
        // Badge editor swf.
        bind<BadgeEditorSwfMovie>().toProvider<BadgeEditorSwfMovieProvider>()
        bind<BadgeEditorSwf>().toProvider<BadgeEditorSwfProvider>()
        // Habbo registration swf.
        bind<HabboRegistrationSwfMovie>().toProvider<HabboRegistrationSwfMovieProvider>()
        bind<HabboRegistrationSwf>().toProvider<HabboRegistrationSwfProvider>()
        // Human body swf.
        bind<HumanBodySwfMovie>().toProvider<HumanBodySwfMovieProvider>()
        bind<HumanBodySwf>().toProvider<HumanBodySwfProvider>()
    }
}