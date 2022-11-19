package com.habbokt.api

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.mp.KoinPlatformTools.defaultContext
import org.koin.mp.KoinPlatformTools.defaultLazyMode

/**
 * @author Jordan Abraham
 */
inline fun <reified T : Any> inject(): Lazy<T> = lazyInject()

@PublishedApi
internal inline fun <reified T : Any> lazyInject(
    qualifier: Qualifier? = null,
    mode: LazyThreadSafetyMode = defaultLazyMode(),
    noinline parameters: ParametersDefinition? = null
): Lazy<T> = defaultContext().get().inject(qualifier, mode, parameters)