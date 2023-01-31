package com.habbokt.page

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
class BlankPage : Page<BlankTemplate>(
    template = { _, _ -> BlankTemplate }
)