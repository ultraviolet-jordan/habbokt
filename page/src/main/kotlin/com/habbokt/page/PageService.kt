package com.habbokt.page

import com.google.inject.Inject

/**
 * @author Jordan Abraham
 */
abstract class PageService<A : Page<*, Z>, Z : PageRequest, G : ResponseType, P : ResponseType>(
    private val get: (suspend Z.(A) -> G)? = null,
    private val post: (suspend Z.(A) -> P)? = null
) {
    @Inject
    private lateinit var page: A

    suspend fun getRequest(request: Z): G {
        require(get != null)
        return get.invoke(request, page)
    }

    suspend fun postRequest(request: Z): P {
        require(post != null)
        return post.invoke(request, page)
    }
}