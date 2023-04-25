---
title: NavigateProxyPacket
---
//[packet](../../../index.html)/[com.habbokt.packet.dasm.navigator.navigate](../index.html)/[NavigateProxyPacket](index.html)



# NavigateProxyPacket



[jvm]\
data class [NavigateProxyPacket](index.html)(val hideFullRooms: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val category: RoomCategoryDAO, val subCategories: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomCategoryDAO&gt;, val rooms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomDAO&gt;) : [ProxyPacket](../../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html)

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [NavigateProxyPacket](-navigate-proxy-packet.html) | [jvm]<br>constructor(hideFullRooms: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), category: RoomCategoryDAO, subCategories: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomCategoryDAO&gt;, rooms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomDAO&gt;) |


## Properties


| Name | Summary |
|---|---|
| [category](category.html) | [jvm]<br>val [category](category.html): RoomCategoryDAO |
| [hideFullRooms](hide-full-rooms.html) | [jvm]<br>val [hideFullRooms](hide-full-rooms.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [rooms](rooms.html) | [jvm]<br>val [rooms](rooms.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomDAO&gt; |
| [subCategories](sub-categories.html) | [jvm]<br>val [subCategories](sub-categories.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;RoomCategoryDAO&gt; |

