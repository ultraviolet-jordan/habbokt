package com.habbokt.page.habboimaging.avatarimage

import com.google.inject.Inject
import com.google.inject.Singleton
import com.habbokt.page.BlankPage
import com.habbokt.page.BlankPageService
import com.habbokt.swf.avatarsbig.AvatarsBigSwf
import com.habbokt.xml.XMLDocument
import com.habbokt.xml.draworder.domain.DrawOrder
import com.habbokt.xml.figuredata.domain.FigureData
import com.habbokt.xml.partsets.domain.PartSets
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import java.awt.Color
import java.awt.image.BufferedImage

/**
 * @author Jordan Abraham
 */
@Singleton
class AvatarImageService @Inject constructor(
    page: BlankPage,
    private val figureDataDocument: XMLDocument<FigureData>,
    private val drawOrderDocument: XMLDocument<DrawOrder>,
    private val partSetsDocument: XMLDocument<PartSets>,
    private val avatarsBigSwf: AvatarsBigSwf
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

        val hairImage = hair(figureData, hair) ?: return call.respond(HttpStatusCode.BadRequest)
        call.respondPng(hairImage) // TODO
    }

    private fun hair(figureData: FigureData, hair: String?): BufferedImage? {
        val split = hair?.split("-")
        val part = split?.get(0)
        val setId = split?.get(1)
        val colorId = split?.get(2)

        val xmlSetType = figureData.sets.setTypes.firstOrNull { it.type == part }
        val xmlPart = xmlSetType?.sets?.firstOrNull { it.id == setId?.toInt() }?.part
        val xmlPartId = xmlPart?.id
        val xmlPartType = xmlPart?.type
        val xmlColor = figureData.colors.palettes.firstOrNull { it.id == xmlSetType?.paletteId }?.colors?.firstOrNull { it.id == colorId?.toInt() }

        val swfString = "h_std_${part}_${xmlPartId}_2_0"
        val swfHairObject = avatarsBigSwf.data.firstOrNull { it.export.name == swfString }
        val swfHairImage = swfHairObject?.image?.bufferedImage ?: swfHairObject?.image2?.bufferedImage

        return swfHairImage?.applyHexColor(xmlColor?.hex)
    }

    private fun BufferedImage.applyHexColor(hex: String?): BufferedImage {
        val overlay = Color.decode("#$hex")
        for (x in 0 until width) {
            for (y in 0 until height) {
                val currPixelColor = Color(getRGB(x, y), true)
                if (currPixelColor.alpha > 0) {
                    val newPixelColor = Color(
                        overlay.red * currPixelColor.red / 255,
                        overlay.green * currPixelColor.green / 255,
                        overlay.blue * currPixelColor.blue / 255,
                        currPixelColor.alpha
                    )
                    setRGB(x, y, newPixelColor.rgb)
                }
            }
        }
        return this
    }
}