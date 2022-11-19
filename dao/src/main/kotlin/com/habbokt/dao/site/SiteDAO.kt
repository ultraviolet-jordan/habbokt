package com.habbokt.dao.site

import java.io.Serializable

/**
 * @author Jordan Abraham
 */
data class SiteDAO(
    val siteName: String,
    val sitePath: String,
    val staticContentPath: String,
    val serverOnline: Boolean,
    val loaderGameIp: String,
    val loaderGamePort: Int,
    val loaderDcr: String,
    val loaderVariables: String,
    val loaderTexts: String
) : Serializable
