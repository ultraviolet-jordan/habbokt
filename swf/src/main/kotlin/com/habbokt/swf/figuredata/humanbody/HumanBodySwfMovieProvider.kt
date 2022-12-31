package com.habbokt.swf.figuredata.humanbody

import com.flagstone.transform.Movie
import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HumanBodySwfMovieProvider : Provider<HumanBodySwfMovie> {
    override fun get(): HumanBodySwfMovie = Movie()
        .apply {
            decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/figuredata/hh_human_body.swf")!!.toURI()))
        }.let(::HumanBodySwfMovie)
}