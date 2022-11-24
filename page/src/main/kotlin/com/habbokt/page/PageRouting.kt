package com.habbokt.page

/**
 * @author Jordan Abraham
 */
interface PageRouting {
    /**
     * Route endpoints for this page.
     */
    fun route(): PageRoute
}