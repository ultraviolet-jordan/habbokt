---
title: com.habbokt.packet.dasm.handshake.ssoticket
---
//[packet](../../index.html)/[com.habbokt.packet.dasm.handshake.ssoticket](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [SSOTicketPacket](-s-s-o-ticket-packet/index.html) | [jvm]<br>data class [SSOTicketPacket](-s-s-o-ticket-packet/index.html)(val ssoTicket: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Packet](../../../api/api/com.habbokt.api.packet/-packet/index.html) |
| [SSOTicketPacketDisassembler](-s-s-o-ticket-packet-disassembler/index.html) | [jvm]<br>class [SSOTicketPacketDisassembler](-s-s-o-ticket-packet-disassembler/index.html) : [PacketDisassembler](../../../api/api/com.habbokt.api.packet/-packet-disassembler/index.html)&lt;[SSOTicketPacket](-s-s-o-ticket-packet/index.html)&gt; |
| [SSOTicketPacketHandler](-s-s-o-ticket-packet-handler/index.html) | [jvm]<br>class [SSOTicketPacketHandler](-s-s-o-ticket-packet-handler/index.html) : [PacketHandler](../../../api/api/com.habbokt.api.packet/-packet-handler/index.html)&lt;[SSOTicketProxyPacket](-s-s-o-ticket-proxy-packet/index.html)&gt; |
| [SSOTicketProxyPacket](-s-s-o-ticket-proxy-packet/index.html) | [jvm]<br>data class [SSOTicketProxyPacket](-s-s-o-ticket-proxy-packet/index.html)(val userId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [ProxyPacket](../../../api/api/com.habbokt.api.packet/-proxy-packet/index.html) |
| [SSOTicketProxyPacketHandler](-s-s-o-ticket-proxy-packet-handler/index.html) | [jvm]<br>class [SSOTicketProxyPacketHandler](-s-s-o-ticket-proxy-packet-handler/index.html)@Injectconstructor(playersService: PlayersService) : [ProxyPacketHandler](../../../api/api/com.habbokt.api.packet/-proxy-packet-handler/index.html)&lt;[SSOTicketPacket](-s-s-o-ticket-packet/index.html), [SSOTicketProxyPacket](-s-s-o-ticket-proxy-packet/index.html)&gt; |

