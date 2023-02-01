package com.habbokt.page

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
class BlankPage<Z : PageRequest> : Page<BlankTemplate, Z>(
    template = { BlankTemplate }
)