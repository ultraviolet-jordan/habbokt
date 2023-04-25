---
title: com.habbokt.packet.dasm.navigator.navigate
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.navigator.navigate](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [NavigatePacket](-navigate-packet/index.html) | [jvm]<br>data class [NavigatePacket](-navigate-packet/index.html)(val mask: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val depth: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [NavigatePacketDisassembler](-navigate-packet-disassembler/index.html) | [jvm]<br>class [NavigatePacketDisassembler](-navigate-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[NavigatePacket](-navigate-packet/index.html)&gt; |
| [NavigatePacketHandler](-navigate-packet-handler/index.html) | [jvm]<br>class [NavigatePacketHandler](-navigate-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[NavigateProxyPacket](-navigate-proxy-packet/index.html)&gt; |
| [NavigateProxyPacket](-navigate-proxy-packet/index.html) | [jvm]<br>data class [NavigateProxyPacket](-navigate-proxy-packet/index.html)(val hideFullRooms: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val category: RoomCategoryDAO, val subCategories: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomCategoryDAO&gt;, val rooms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomDAO&gt;) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [NavigateProxyPacketHandler](-navigate-proxy-packet-handler/index.html) | [jvm]<br>class [NavigateProxyPacketHandler](-navigate-proxy-packet-handler/index.html)@Injectconstructor(roomsService: RoomsService, roomsCategoriesService: RoomsCategoriesService) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[NavigatePacket](-navigate-packet/index.html), [NavigateProxyPacket](-navigate-proxy-packet/index.html)&gt; |

