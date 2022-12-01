package com.habbokt.swf.badgeeditor

import com.flagstone.transform.Movie
import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Singleton
import com.habbokt.swf.SwfFile
import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
class BadgeEditorSwf(
    movie: Movie
) : SwfFile<BadgeEditorSwfObject>(
    name = "BadgeEditor.swf",
    data = buildList {
        movie.objects
            .drop(3)
            .chunked(3) {
                if (it.size < 3) return@chunked
                if (it[0] !is DefineImage2 && it[0] !is DefineImage) return@chunked
                if (it[1] !is DefineShape) return@chunked
                if (it[2] !is DefineMovieClip) return@chunked
                val isImage2 = it[0] is DefineImage2
                add(
                    BadgeEditorSwfObject(
                        image = if (!isImage2) SwfImage(it[0] as DefineImage) else null,
                        image2 = if (isImage2) SwfImage2(it[0] as DefineImage2) else null,
                        shape = SwfShape(it[1] as DefineShape),
                        clip = SwfMovieClip(it[2] as DefineMovieClip)
                    )
                )
            }
    }
)