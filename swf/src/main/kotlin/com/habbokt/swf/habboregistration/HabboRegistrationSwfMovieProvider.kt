package com.habbokt.swf.habboregistration

import com.flagstone.transform.Movie
import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
internal class HabboRegistrationSwfMovieProvider : Provider<HabboRegistrationSwfMovie> {
    override fun get(): HabboRegistrationSwfMovie = Movie()
        .apply { decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/HabboRegistration.swf")!!.toURI())) }
        .let(::HabboRegistrationSwfMovie)
}