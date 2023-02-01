package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPageService
import com.habbokt.page.None
import com.habbokt.page.Png
import com.habbokt.page.png
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    private val httpClient: HttpClient
) : BlankPageService<AvatarImageRequest, Png, None>(
    get = {
        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = "habbo.com"
                path("habbo-imaging/avatarimage")
                parameters.append("figure", figure)
                parameters.append("size", size)
                parameters.append("direction", direction)
                parameters.append("head_direction", direction)
                parameters.append("crr", crr)
                parameters.append("gesture", gesture)
                parameters.append("frame", frame)
            }
        }

        val image = withContext(Dispatchers.IO) {
            ImageIO.read(ByteArrayInputStream(response.body<ByteArray>()))
        }

        png(image)
    }
)