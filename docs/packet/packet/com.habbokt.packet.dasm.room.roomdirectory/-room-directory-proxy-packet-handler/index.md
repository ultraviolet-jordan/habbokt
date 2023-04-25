---
title: RoomDirectoryProxyPacketHandler
---
//[packet](../../../index.html)/[com.habbokt.packet.dasm.room.roomdirectory](../index.html)/[RoomDirectoryProxyPacketHandler](index.html)



# RoomDirectoryProxyPacketHandler



[jvm]\
class [RoomDirectoryProxyPacketHandler](index.html)@Injectconstructor(roomsService: RoomsService) : [ProxyPacketHandler](../../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[RoomDirectoryPacket](../-room-directory-packet/index.html), [RoomDirectoryProxyPacket](../-room-directory-proxy-packet/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [RoomDirectoryProxyPacketHandler](-room-directory-proxy-packet-handler.html) | [jvm]<br>@Inject<br>constructor(roomsService: RoomsService) |


## Properties


| Name | Summary |
|---|---|
| [handler](index.html#981137687%2FProperties%2F-1665284158) | [jvm]<br>val [handler](index.html#981137687%2FProperties%2F-1665284158): suspend [Client](../../../../api/api/com.habbokt.api.client/-client/index.html).([RoomDirectoryPacket](../-room-directory-packet/index.html)) -&gt; [RoomDirectoryProxyPacket](../-room-directory-proxy-packet/index.html)? |

