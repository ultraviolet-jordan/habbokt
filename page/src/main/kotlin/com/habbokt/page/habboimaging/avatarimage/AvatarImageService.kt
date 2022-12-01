package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import com.habbokt.xml.XMLDocument
import com.habbokt.xml.draworder.domain.DrawOrder
import com.habbokt.xml.figuredata.domain.FigureData
import com.habbokt.xml.partsets.domain.PartSets
import io.ktor.server.application.ApplicationCall

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    page: BlankPage,
    private val figureDataDocument: XMLDocument<FigureData>,
    private val drawOrderDocument: XMLDocument<DrawOrder>,
    private val partSetsDocument: XMLDocument<PartSets>
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
        val hair = figureParts?.firstOrNull { it.startsWith("hr-") }
        val hat = figureParts?.firstOrNull { it.startsWith("ha-") }
        val head = figureParts?.firstOrNull { it.startsWith("hd-") }
        val chest = figureParts?.firstOrNull { it.startsWith("ch-") }
        val chestAccessory = figureParts?.firstOrNull { it.startsWith("cc-") }
        val legs = figureParts?.firstOrNull { it.startsWith("lg-") }
        val shoes = figureParts?.firstOrNull { it.startsWith("sh-") }
        val waist = figureParts?.firstOrNull { it.startsWith("wa-") }

        val figureData = figureDataDocument.xml
        val drawOrder = drawOrderDocument.xml
        val partSets = partSetsDocument.xml

        val hairName = hair(figureData, hair, direction)
    }

    private fun hair(figureData: FigureData, hair: String?, direction: String?): String {
        val split = hair?.split("-")
        val part = split?.get(0)
        val setId = split?.get(1)
        val colorId = split?.get(2)

        val swfPart = figureData.sets.setTypes.firstOrNull { it.type == part }?.sets?.firstOrNull { it.id == setId?.toInt() }?.part
        val swfPartId = swfPart?.id
        val swfPartType = swfPart?.type

        return "h_std_${part}_${swfPartId}_2_0"
    }
}