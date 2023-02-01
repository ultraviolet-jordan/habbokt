package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class BlankPageService<Z : PageRequest, G : ResponseType, P : ResponseType>(
    val get: (suspend Z.(BlankPage<Z>) -> G)? = null,
    val post: (suspend Z.(BlankPage<Z>) -> P)? = null
) : PageService<BlankPage<Z>, Z, G, P>(get, post)