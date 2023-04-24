package com.habbokt.page

/**
 * @author Jordan Abraham
 *
 * @see Page
 * @see PageRequest
 * @see PageRouting
 * @see ResponseType
 *
 * @property R The [PageRequest] used for this service.
 * @property G The GET response type for this service.
 * @property P The POST response type for this service.
 * @property get The optional http GET service handling.
 * @property post The optional http POST service handling.
 */
abstract class PageService<R : PageRequest, G : ResponseType, P : ResponseType>(
    private val get: (suspend R.() -> G)? = null,
    private val post: (suspend R.() -> P)? = null
) {

    /**
     * Handles the http GET request to this service if applicable.
     *
     * @param request The [PageRequest] for this service handling.
     */
    suspend fun getRequest(request: R): G {
        require(get != null)
        return get.invoke(request)
    }

    /**
     * Handles the http POST request to this service if applicable.
     *
     * @param request The [PageRequest] for this service handling.
     */
    suspend fun postRequest(request: R): P {
        require(post != null)
        return post.invoke(request)
    }
}