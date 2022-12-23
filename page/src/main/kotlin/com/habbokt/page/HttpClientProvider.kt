package com.habbokt.page

import com.google.inject.Provider
import com.google.inject.Singleton
import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java

/**
 * @author Jordan Abraham
 */
@Singleton
class HttpClientProvider : Provider<HttpClient> {
    override fun get(): HttpClient = HttpClient(Java)
}