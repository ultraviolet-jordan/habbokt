package com.habbokt.page.export

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.PageRouting
import com.habbokt.page.Route
import com.habbokt.swf.avatarsbig.AvatarsBigSwf
import com.habbokt.swf.badgeeditor.BadgeEditorSwf
import com.habbokt.swf.figuredata.humanbody.HumanBodySwf
import com.habbokt.swf.habboregistration.HabboRegistrationSwf
import io.ktor.server.application.call
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import java.io.File
import java.nio.file.Path
import javax.imageio.ImageIO
import kotlin.io.path.createDirectories
import kotlin.io.path.notExists

/**
 * @author Jordan Abraham
 */
@Singleton
class ExportPageRouting @Inject constructor(
    private val avatarsBigSwf: AvatarsBigSwf,
    private val habboRegistrationSwf: HabboRegistrationSwf,
    private val badgeEditorSwf: BadgeEditorSwf,
    private val humanBodySwf: HumanBodySwf
) : PageRouting(Route {
    get("/export") {
        exportAvatarsBigImages(avatarsBigSwf)
        exportHabboRegistrationImages(habboRegistrationSwf)
        exportBadgeEditorImages(badgeEditorSwf)
        exportHumanBodyImages(humanBodySwf)
        call.respondRedirect("/")
    }
})

private fun exportAvatarsBigImages(avatarsBigSwf: AvatarsBigSwf) {
    avatarsBigSwf.data.forEach {
        val path = Path.of("../export/avatars_big.swf/png/")
        if (path.notExists()) path.createDirectories()
        ImageIO.write(it.image?.bufferedImage ?: it.image2?.bufferedImage, "png", File(path.toString(), "${it.export.name}.png"))
    }
}

private fun exportHabboRegistrationImages(habboRegistrationSwf: HabboRegistrationSwf) {
    habboRegistrationSwf.data.forEach {
        val path = Path.of("../export/HabboRegistration.swf/png/")
        if (path.notExists()) path.createDirectories()
        ImageIO.write(it.image.bufferedImage, "png", File(path.toString(), "${it.export.name}.png"))
    }
}

private fun exportBadgeEditorImages(badgeEditorSwf: BadgeEditorSwf) {
    badgeEditorSwf.data.forEachIndexed { index, badgeEditorSwfObject ->
        val path = Path.of("../export/BadgeEditor.swf/png/")
        if (path.notExists()) path.createDirectories()
        ImageIO.write(badgeEditorSwfObject.image?.bufferedImage ?: badgeEditorSwfObject.image2?.bufferedImage, "png", File(path.toString(), "${index}.png"))
    }
}

private fun exportHumanBodyImages(humanBodySwf: HumanBodySwf) {
    humanBodySwf.data.forEach {
        val path = Path.of("../export/figuredata/hh_human_body.swf/png/")
        if (path.notExists()) path.createDirectories()
        ImageIO.write(it.image.bufferedImage, "png", File(path.toString(), "${it.name}.png"))
    }
}