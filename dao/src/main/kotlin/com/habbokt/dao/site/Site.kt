package com.habbokt.dao.site

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class Site(
    val siteName: String,
    val staticContentPath: String,
    val serverOnline: Boolean,
    val loaderGameIp: String,
    val loaderGamePort: String,
    val loaderDcr: String,
    val loaderVariables: String,
    val loaderTexts: String
) : Serializable
