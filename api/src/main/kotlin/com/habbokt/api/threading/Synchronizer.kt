package com.habbokt.api.threading

/**
 * @author Jordan Abraham
 */
abstract class Synchronizer : Runnable {
    abstract fun start()
    abstract fun stop()
}