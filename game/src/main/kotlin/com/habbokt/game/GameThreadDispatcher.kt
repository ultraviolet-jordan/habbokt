package com.habbokt.game

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.ForkJoinPool

/**
 * @author Jordan Abraham
 */
data class GameThreadDispatcher(
    val forkJoinPool: ForkJoinPool,
    val dispatcher: CoroutineDispatcher
) { constructor(forkJoinPool: ForkJoinPool) : this(forkJoinPool, forkJoinPool.asCoroutineDispatcher()) }