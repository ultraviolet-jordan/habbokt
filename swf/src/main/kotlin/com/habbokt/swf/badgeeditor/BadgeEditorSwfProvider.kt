package com.habbokt.swf.badgeeditor

import com.flagstone.transform.MovieTag
import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfMovieDataProvider
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
internal class BadgeEditorSwfProvider @Inject constructor(
    private val badgeEditorSwfMovie: BadgeEditorSwfMovie
) : SwfMovieDataProvider<BadgeEditorSwf, BadgeEditorSwfObject> {
    override fun dataMapping(): List<BadgeEditorSwfObject> = badgeEditorSwfMovie
        .movie
        .objects
        .drop(3)
        .chunked(3)
        .filterBadgeGroups()
        .map {
            val isImage2 = it[0] is DefineImage2
            BadgeEditorSwfObject(
                image = if (!isImage2) SwfImage(it[0] as DefineImage) else null,
                image2 = if (isImage2) SwfImage2(it[0] as DefineImage2) else null,
                shape = SwfShape(it[1] as DefineShape),
                clip = SwfMovieClip(it[2] as DefineMovieClip)
            )
        }

    override fun get(): BadgeEditorSwf = BadgeEditorSwf(dataMapping())

    private fun List<List<MovieTag>>.filterBadgeGroups(): List<List<MovieTag>> = filter {
        it.size >= 3 && (it[0] is DefineImage2 || it[0] is DefineImage) && it[1] is DefineShape && it[2] is DefineMovieClip
    }
}