package com.habbokt.swf.badgeeditor

import com.flagstone.transform.Movie
import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
internal class BadgeEditorSwfMovieProvider : Provider<BadgeEditorSwfMovie> {
    override fun get(): BadgeEditorSwfMovie = Movie()
        .apply { decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/BadgeEditor.swf")!!.toURI())) }
        .let(::BadgeEditorSwfMovie)
}