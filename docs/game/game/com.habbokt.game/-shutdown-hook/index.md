---
title: ShutdownHook
---
//[game](../../../index.html)/[com.habbokt.game](../index.html)/[ShutdownHook](index.html)



# ShutdownHook



[jvm]\
class [ShutdownHook](index.html)(logger: Logger, applicationEngine: ApplicationEngine, database: HikariDatabase, gameServer: [GameServer](../-game-server/index.html), gameSynchronizer: [GameSynchronizer](../-game-synchronizer/index.html)) : [Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)

#### Author



Jordan Abraham



## Constructors


| | |
|---|---|
| [ShutdownHook](-shutdown-hook.html) | [jvm]<br>constructor(logger: Logger, applicationEngine: ApplicationEngine, database: HikariDatabase, gameServer: [GameServer](../-game-server/index.html), gameSynchronizer: [GameSynchronizer](../-game-synchronizer/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [checkAccess](index.html#78173473%2FFunctions%2F-296670760) | [jvm]<br>fun [~~checkAccess~~](index.html#78173473%2FFunctions%2F-296670760)() |
| [countStackFrames](index.html#2119597422%2FFunctions%2F-296670760) | [jvm]<br>open fun [~~countStackFrames~~](index.html#2119597422%2FFunctions%2F-296670760)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getId](index.html#1154473532%2FFunctions%2F-296670760) | [jvm]<br>open fun [getId](index.html#1154473532%2FFunctions%2F-296670760)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getStackTrace](index.html#-1953074182%2FFunctions%2F-296670760) | [jvm]<br>open fun [getStackTrace](index.html#-1953074182%2FFunctions%2F-296670760)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StackTraceElement](https://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html)&gt; |
| [getState](index.html#-1528754478%2FFunctions%2F-296670760) | [jvm]<br>open fun [getState](index.html#-1528754478%2FFunctions%2F-296670760)(): [Thread.State](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.State.html) |
| [getThreadGroup](index.html#1757263054%2FFunctions%2F-296670760) | [jvm]<br>fun [getThreadGroup](index.html#1757263054%2FFunctions%2F-296670760)(): [ThreadGroup](https://docs.oracle.com/javase/8/docs/api/java/lang/ThreadGroup.html) |
| [interrupt](index.html#-638971094%2FFunctions%2F-296670760) | [jvm]<br>open fun [interrupt](index.html#-638971094%2FFunctions%2F-296670760)() |
| [isAlive](index.html#-92445750%2FFunctions%2F-296670760) | [jvm]<br>fun [isAlive](index.html#-92445750%2FFunctions%2F-296670760)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [join](index.html#-890778781%2FFunctions%2F-296670760) | [jvm]<br>fun [join](index.html#-890778781%2FFunctions%2F-296670760)()<br>fun [join](index.html#1587127286%2FFunctions%2F-296670760)(p0: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>fun [join](index.html#-1662778457%2FFunctions%2F-296670760)(p0: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [resume](index.html#-1122232896%2FFunctions%2F-296670760) | [jvm]<br>fun [~~resume~~](index.html#-1122232896%2FFunctions%2F-296670760)() |
| [run](run.html) | [jvm]<br>open override fun [run](run.html)() |
| [start](index.html#614703627%2FFunctions%2F-296670760) | [jvm]<br>open fun [start](index.html#614703627%2FFunctions%2F-296670760)() |
| [stop](index.html#1315242891%2FFunctions%2F-296670760) | [jvm]<br>fun [~~stop~~](index.html#1315242891%2FFunctions%2F-296670760)() |
| [suspend](index.html#-1383820431%2FFunctions%2F-296670760) | [jvm]<br>fun [~~suspend~~](index.html#-1383820431%2FFunctions%2F-296670760)() |
| [toString](index.html#-1632822175%2FFunctions%2F-296670760) | [jvm]<br>open override fun [toString](index.html#-1632822175%2FFunctions%2F-296670760)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |


## Properties


| Name | Summary |
|---|---|
| [contextClassLoader](index.html#282378833%2FProperties%2F-296670760) | [jvm]<br>var [contextClassLoader](index.html#282378833%2FProperties%2F-296670760): [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html) |
| [daemon](index.html#1343080265%2FProperties%2F-296670760) | [jvm]<br>var [daemon](index.html#1343080265%2FProperties%2F-296670760): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [interrupted](index.html#1961623595%2FProperties%2F-296670760) | [jvm]<br>val [interrupted](index.html#1961623595%2FProperties%2F-296670760): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [name](index.html#425282850%2FProperties%2F-296670760) | [jvm]<br>var [name](index.html#425282850%2FProperties%2F-296670760): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [priority](index.html#-2119236567%2FProperties%2F-296670760) | [jvm]<br>var [priority](index.html#-2119236567%2FProperties%2F-296670760): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [uncaughtExceptionHandler](index.html#-613301027%2FProperties%2F-296670760) | [jvm]<br>var [uncaughtExceptionHandler](index.html#-613301027%2FProperties%2F-296670760): [Thread.UncaughtExceptionHandler](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.UncaughtExceptionHandler.html) |

