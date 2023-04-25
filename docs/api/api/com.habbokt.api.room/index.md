---
title: com.habbokt.api.room
---
//[api](../../index.html)/[com.habbokt.api.room](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [Room](-room/index.html) | [jvm]<br>data class [Room](-room/index.html)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val port: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var userCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), var maxUsers: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val door: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val swfCast: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var usersInQueue: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), var visible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val owner: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [RoomCategory](-room-category/index.html) | [jvm]<br>data class [RoomCategory](-room-category/index.html)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val public: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val rooms: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Room](-room/index.html)&gt;) |
| [RoomSubCategory](-room-sub-category/index.html) | [jvm]<br>data class [RoomSubCategory](-room-sub-category/index.html)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val parentId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

