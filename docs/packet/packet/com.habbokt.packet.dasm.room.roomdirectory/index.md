---
title: com.habbokt.packet.dasm.room.roomdirectory
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.room.roomdirectory](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [RoomDirectoryPacket](-room-directory-packet/index.html) | [jvm]<br>data class [RoomDirectoryPacket](-room-directory-packet/index.html)(val typeId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val roomId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val doorId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [RoomDirectoryPacketDisassembler](-room-directory-packet-disassembler/index.html) | [jvm]<br>class [RoomDirectoryPacketDisassembler](-room-directory-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[RoomDirectoryPacket](-room-directory-packet/index.html)&gt; |
| [RoomDirectoryPacketHandler](-room-directory-packet-handler/index.html) | [jvm]<br>class [RoomDirectoryPacketHandler](-room-directory-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[RoomDirectoryProxyPacket](-room-directory-proxy-packet/index.html)&gt; |
| [RoomDirectoryProxyPacket](-room-directory-proxy-packet/index.html) | [jvm]<br>data class [RoomDirectoryProxyPacket](-room-directory-proxy-packet/index.html)(val room: RoomDAO) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [RoomDirectoryProxyPacketHandler](-room-directory-proxy-packet-handler/index.html) | [jvm]<br>class [RoomDirectoryProxyPacketHandler](-room-directory-proxy-packet-handler/index.html)@Injectconstructor(roomsService: RoomsService) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[RoomDirectoryPacket](-room-directory-packet/index.html), [RoomDirectoryProxyPacket](-room-directory-proxy-packet/index.html)&gt; |

