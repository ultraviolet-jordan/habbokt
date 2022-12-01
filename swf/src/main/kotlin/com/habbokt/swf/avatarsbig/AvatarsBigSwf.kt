package com.habbokt.swf.avatarsbig

import com.flagstone.transform.Export
import com.flagstone.transform.Movie
import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Singleton
import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfFile
import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarsBigSwf(
    movie: Movie
) : SwfFile<AvatarsBigSwfObject>(
    name = "avatars_big.swf",
    data = buildList {
        movie.objects
            .drop(6)
            .chunked(4) {
                if (it.size < 4) return@chunked
                if (it[0] !is Export) return@chunked
                if (it[1] !is DefineImage2 && it[1] !is DefineImage) return@chunked
                if (it[2] !is DefineShape) return@chunked
                if (it[3] !is DefineMovieClip) return@chunked
                val isImage2 = it[1] is DefineImage2
                add(
                    AvatarsBigSwfObject(
                        export = SwfExport(it[0] as Export),
                        image = if (!isImage2) SwfImage(it[1] as DefineImage) else null,
                        image2 = if (isImage2) SwfImage2(it[1] as DefineImage2) else null,
                        shape = SwfShape(it[2] as DefineShape),
                        clip = SwfMovieClip(it[3] as DefineMovieClip)
                    )
                )
            }
    }
)