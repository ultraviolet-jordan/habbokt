package com.habbokt.api.client

/**
 * @author Jordan Abraham
 */
interface ConnectionPool<T> {
    fun add(type: T): Boolean
    fun drop(type: T): Boolean
    fun collect(): List<T>
}