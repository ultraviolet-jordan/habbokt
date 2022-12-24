package com.habbokt.swf.avatarsbig

import com.flagstone.transform.Movie
import com.google.inject.Provider
import com.google.inject.Singleton
import java.io.File

/**
 * @author Jordan Abraham
 */
@Singleton
internal class AvatarsBigSwfMovieProvider : Provider<AvatarsBigSwfMovie> {
    override fun get(): AvatarsBigSwfMovie {
        val movie = Movie().apply {
            decodeFromFile(File(this::class.java.classLoader.getResource("www/flash/avatars_big.swf")!!.toURI()))
        }
        return AvatarsBigSwfMovie(movie)
    }
}