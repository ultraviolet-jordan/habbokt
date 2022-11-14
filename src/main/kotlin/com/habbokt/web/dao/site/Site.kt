package com.habbokt.web.dao.site

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class Site(
    val siteName: String,
    val staticContentPath: String
) : Serializable
