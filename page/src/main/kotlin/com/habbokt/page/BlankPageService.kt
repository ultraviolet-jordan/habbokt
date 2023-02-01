package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class BlankPageService<R : PageRequest, G : ResponseType, P : ResponseType>(
    get: (suspend R.() -> G)? = null,
    post: (suspend R.() -> P)? = null
) : PageService<R, G, P>(get, post)