package com.habbokt.swf.habboregistration

import com.flagstone.transform.Export
import com.flagstone.transform.MovieTag
import com.flagstone.transform.image.DefineImage2
import com.flagstone.transform.movieclip.DefineMovieClip
import com.flagstone.transform.shape.DefineShape
import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.swf.SwfExport
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieClip
import com.habbokt.swf.SwfMovieDataProvider
import com.habbokt.swf.SwfShape

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HabboRegistrationSwfProvider @Inject constructor(
    private val habboRegistrationSwfMovie: HabboRegistrationSwfMovie
) : SwfMovieDataProvider<HabboRegistrationSwf> {
    override fun get(): HabboRegistrationSwf = habboRegistrationSwfMovie
        .movie
        .objects
        .drop(n = 19)
        .chunked(size = 4)
        .filterGroups()
        .map {
            HabboRegistrationSwfObject(
                export = SwfExport(it[0] as Export),
                image = SwfImage2(it[1] as DefineImage2),
                shape = SwfShape(it[2] as DefineShape),
                clip = SwfMovieClip(it[3] as DefineMovieClip)
            )
        }
        .let(::HabboRegistrationSwf)

    private fun List<List<MovieTag>>.filterGroups(): List<List<MovieTag>> = filter {
        it.size >= 4 && it[0] is Export && it[1] is DefineImage2 && it[2] is DefineShape && it[3] is DefineMovieClip
    }
}