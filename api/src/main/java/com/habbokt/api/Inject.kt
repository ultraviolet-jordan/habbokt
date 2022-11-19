package com.habbokt.api

import org.koin.mp.KoinPlatformTools

/**
 * @author Jordan Abraham
 */
inline fun <reified T : Any> inject(): Lazy<T> = KoinPlatformTools.defaultContext().get().inject(null, KoinPlatformTools.defaultLazyMode(), null)