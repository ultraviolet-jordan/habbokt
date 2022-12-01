package com.habbokt.swf.avatarsbig

import com.flagstone.transform.Export
import com.flagstone.transform.Movie
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Singleton
import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfFile
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfObject
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarsBigSwf(
    movie: Movie
) : SwfFile(name = "avatars_big.swf", buildList {
    movie.objects.drop(6).chunked(4) {
        if (it.size < 4) return@chunked
        if (it[1] !is DefineImage2) return@chunked // TODO These are of type DefineImage
        add(SwfObject(
            export = SwfExport(it[0] as Export),
            image = SwfImage2(it[1] as DefineImage2),
            shape = SwfShape(it[2] as DefineShape),
            clip = SwfMovieClip(it[3] as DefineMovieClip)
        ))
    }
})