package com.habbokt.swf

import com.google.inject.Provider

/**
 * @author Jordan Abraham
 */
internal interface SwfMovieDataProvider<T, O> : Provider<T> {
    fun dataMapping(): List<O>
}