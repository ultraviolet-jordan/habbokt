package com.habbokt.game

import java.util.concurrent.ScheduledExecutorService

/**
 * @author Jordan Abraham
 */
data class GameThread(
    val executor: ScheduledExecutorService
)