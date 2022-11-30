package com.habbokt.xml.draworder

import com.google.inject.Singleton
import com.habbokt.xml.XMLDocument
import com.habbokt.xml.draworder.domain.DrawOrder

/**
 * @author Jordan Abraham
 */
@Singleton
class DrawOrderDocument(drawOrder: DrawOrder) : XMLDocument<DrawOrder>(drawOrder)