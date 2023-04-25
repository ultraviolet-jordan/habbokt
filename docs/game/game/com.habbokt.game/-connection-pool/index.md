---
title: ConnectionPool
---
//[game](../../../index.html)/[com.habbokt.game](../index.html)/[ConnectionPool](index.html)



# ConnectionPool



[jvm]\
class [ConnectionPool](index.html) : [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt; 

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [ConnectionPool](-connection-pool.html) | [jvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [add](index.html#1773691900%2FFunctions%2F-296670760) | [jvm]<br>open override fun [add](index.html#1773691900%2FFunctions%2F-296670760)(element: [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [addAll](index.html#644230587%2FFunctions%2F-296670760) | [jvm]<br>open override fun [addAll](index.html#644230587%2FFunctions%2F-296670760)(elements: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [clear](index.html#-767459876%2FFunctions%2F-296670760) | [jvm]<br>open override fun [clear](index.html#-767459876%2FFunctions%2F-296670760)() |
| [contains](index.html#-187525894%2FFunctions%2F-296670760) | [jvm]<br>open operator override fun [contains](index.html#-187525894%2FFunctions%2F-296670760)(element: [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [containsAll](index.html#436379449%2FFunctions%2F-296670760) | [jvm]<br>open override fun [containsAll](index.html#436379449%2FFunctions%2F-296670760)(elements: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [dropAllAndCloseAndClear](drop-all-and-close-and-clear.html) | [jvm]<br>fun [dropAllAndCloseAndClear](drop-all-and-close-and-clear.html)()<br>Close all clients inside of this connection pool and set the accepting to false so this pool no longer accepts connections. |
| [forEach](index.html#-1869540773%2FFunctions%2F-296670760) | [jvm]<br>open fun [forEach](index.html#-1869540773%2FFunctions%2F-296670760)(p0: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)&lt;in [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;) |
| [isEmpty](index.html#-477621106%2FFunctions%2F-296670760) | [jvm]<br>open override fun [isEmpty](index.html#-477621106%2FFunctions%2F-296670760)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [iterator](index.html#1565777859%2FFunctions%2F-296670760) | [jvm]<br>open operator override fun [iterator](index.html#1565777859%2FFunctions%2F-296670760)(): [MutableIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-iterator/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt; |
| [parallelStream](index.html#-1592339412%2FFunctions%2F-296670760) | [jvm]<br>open fun [parallelStream](index.html#-1592339412%2FFunctions%2F-296670760)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt; |
| [remove](index.html#-198660681%2FFunctions%2F-296670760) | [jvm]<br>open override fun [remove](index.html#-198660681%2FFunctions%2F-296670760)(element: [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAll](index.html#64506038%2FFunctions%2F-296670760) | [jvm]<br>open override fun [removeAll](index.html#64506038%2FFunctions%2F-296670760)(elements: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeIf](index.html#1674717695%2FFunctions%2F-296670760) | [jvm]<br>open fun [removeIf](index.html#1674717695%2FFunctions%2F-296670760)(p0: [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html)&lt;in [Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [retainAll](index.html#-2120382921%2FFunctions%2F-296670760) | [jvm]<br>open override fun [retainAll](index.html#-2120382921%2FFunctions%2F-296670760)(elements: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt;): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [spliterator](index.html#-989466892%2FFunctions%2F-296670760) | [jvm]<br>open override fun [spliterator](index.html#-989466892%2FFunctions%2F-296670760)(): [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt; |
| [stream](index.html#135225651%2FFunctions%2F-296670760) | [jvm]<br>open fun [stream](index.html#135225651%2FFunctions%2F-296670760)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)&lt;[Client](../../../../api/api/com.habbokt.api.client/-client/index.html)&gt; |
| [toArray](index.html#-1215154575%2FFunctions%2F-296670760) | [jvm]<br>open fun &lt;[T](index.html#-1215154575%2FFunctions%2F-296670760) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [~~toArray~~](index.html#-1215154575%2FFunctions%2F-296670760)(p0: [IntFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntFunction.html)&lt;[Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[T](index.html#-1215154575%2FFunctions%2F-296670760)&gt;&gt;): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[T](index.html#-1215154575%2FFunctions%2F-296670760)&gt; |


## Properties


| Name | Summary |
|---|---|
| [closed](closed.html) | [jvm]<br>var [closed](closed.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This property is to check if this connection pool is accepting new connections or not. |
| [size](index.html#1578037672%2FProperties%2F-296670760) | [jvm]<br>open override val [size](index.html#1578037672%2FProperties%2F-296670760): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

