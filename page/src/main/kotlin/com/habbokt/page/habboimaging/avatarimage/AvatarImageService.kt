package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import com.habbokt.xml.draworder.DrawOrder
import com.habbokt.xml.figuredata.FigureData
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    page: BlankPage,
    private val figureData: FigureData,
    private val drawOrder: DrawOrder
) : BlankPageService(page) {
    override suspend fun handleGetRequest(call: ApplicationCall) {
        val parameters = call.parameters
        val figure = parameters["figure"]
        val size = parameters["size"]
        val direction = parameters["direction"]
        val headDirection = parameters["head_direction"]
        val crr = parameters["crr"]
        val gesture = parameters["gesture"]
        val frame = parameters["frame"]

        require(direction?.toInt() in 0..7)
        require(headDirection?.toInt() in 0..7)

        val figureParts = figure?.split(".")
        val hair = figureParts?.filter { it.startsWith("hr-") }
        val hat = figureParts?.filter { it.startsWith("ha-") }
        val head = figureParts?.filter { it.startsWith("hd-") }
        val chest = figureParts?.filter { it.startsWith("ch-") }
        val chestAccessory = figureParts?.filter { it.startsWith("cc-") }
        val legs = figureParts?.filter { it.startsWith("lg-") }
        val shoes = figureParts?.filter { it.startsWith("sh-") }
        val waist = figureParts?.filter { it.startsWith("wa-") }
    }
}