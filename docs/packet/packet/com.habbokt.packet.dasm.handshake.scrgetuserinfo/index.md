---
title: com.habbokt.packet.dasm.handshake.scrgetuserinfo
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.handshake.scrgetuserinfo](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [ScrGetUserInfoPacket](-scr-get-user-info-packet/index.html) | [jvm]<br>data class [ScrGetUserInfoPacket](-scr-get-user-info-packet/index.html)(val productName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [ScrGetUserInfoPacketDisassembler](-scr-get-user-info-packet-disassembler/index.html) | [jvm]<br>class [ScrGetUserInfoPacketDisassembler](-scr-get-user-info-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[ScrGetUserInfoPacket](-scr-get-user-info-packet/index.html)&gt; |
| [ScrGetUserInfoPacketHandler](-scr-get-user-info-packet-handler/index.html) | [jvm]<br>class [ScrGetUserInfoPacketHandler](-scr-get-user-info-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[ScrGetUserInfoProxyPacket](-scr-get-user-info-proxy-packet/index.html)&gt; |
| [ScrGetUserInfoProxyPacket](-scr-get-user-info-proxy-packet/index.html) | [jvm]<br>data class [ScrGetUserInfoProxyPacket](-scr-get-user-info-proxy-packet/index.html)(val productName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [ScrGetUserInfoProxyPacketHandler](-scr-get-user-info-proxy-packet-handler/index.html) | [jvm]<br>class [ScrGetUserInfoProxyPacketHandler](-scr-get-user-info-proxy-packet-handler/index.html) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[ScrGetUserInfoPacket](-scr-get-user-info-packet/index.html), [ScrGetUserInfoProxyPacket](-scr-get-user-info-proxy-packet/index.html)&gt; |

