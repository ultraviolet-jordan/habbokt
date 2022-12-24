package com.habbokt.swf.avatarsbig

import com.flagstone.transform.Export
import com.flagstone.transform.MovieTag
import com.flagstone.transform.image.DefineImage
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfImage
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfMovieDataProvider
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
internal class AvatarsBigSwfProvider @Inject constructor(
    private val avatarsBigSwfMovie: AvatarsBigSwfMovie
) : SwfMovieDataProvider<AvatarsBigSwf, AvatarsBigSwfObject> {
    override fun dataMapping(): List<AvatarsBigSwfObject> = avatarsBigSwfMovie
        .movie
        .objects
        .drop(6)
        .chunked(4)
        .filterAvatarGroups()
        .map {
            val isImage2 = it[1] is DefineImage2
            AvatarsBigSwfObject(
                export = SwfExport(it[0] as Export),
                image = if (!isImage2) SwfImage(it[1] as DefineImage) else null,
                image2 = if (isImage2) SwfImage2(it[1] as DefineImage2) else null,
                shape = SwfShape(it[2] as DefineShape),
                clip = SwfMovieClip(it[3] as DefineMovieClip)
            )
        }

    override fun get(): AvatarsBigSwf = AvatarsBigSwf(dataMapping())

    private fun List<List<MovieTag>>.filterAvatarGroups(): List<List<MovieTag>> = filter {
        it.size >= 4 && it[0] is Export && (it[1] is DefineImage2 || it[1] is DefineImage) && it[2] is DefineShape && it[3] is DefineMovieClip
    }
}