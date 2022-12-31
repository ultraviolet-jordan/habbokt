package com.habbokt.swf.figuredata.humanbody

import com.flagstone.transform.SymbolClass
import com.flagstone.transform.image.DefineImage2
import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.swf.SwfImage2
import com.habbokt.swf.SwfMovieDataProvider

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HumanBodySwfProvider @Inject constructor(
    private val humanBodySwfMovie: HumanBodySwfMovie
) : SwfMovieDataProvider<HumanBodySwf> {
    override fun get(): HumanBodySwf {
        val symbolClass = humanBodySwfMovie.movie.objects.filterIsInstance(SymbolClass::class.java).first()
        return humanBodySwfMovie
            .movie
            .objects
            .filterIsInstance(DefineImage2::class.java)
            .map {
                HumanBodySwfObject(
                    name = symbolClass.objects[it.identifier],
                    image = SwfImage2(it)
                )
            }
            .let(::HumanBodySwf)
    }
}