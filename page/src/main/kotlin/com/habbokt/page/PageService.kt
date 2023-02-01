package com.habbokt.page

/**
 * @author Jordan Abraham
 */
abstract class PageService<R : PageRequest, G : ResponseType, P : ResponseType>(
    private val get: (suspend R.() -> G)? = null,
    private val post: (suspend R.() -> P)? = null
) {

    suspend fun getRequest(request: R): G {
        require(get != null)
        return get.invoke(request)
    }

    suspend fun postRequest(request: R): P {
        require(post != null)
        return post.invoke(request)
    }
}