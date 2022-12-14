package com.habbokt.api.threading

/**
 * @author Jordan Abraham
 */
interface Synchronizer : Runnable {
    fun start()
    fun stop()
}