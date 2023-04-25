---
title: com.habbokt.web
---
//[web](../../index.html)/[com.habbokt.web](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [ApplicationEngineProvider](-application-engine-provider/index.html) | [jvm]<br>class [ApplicationEngineProvider](-application-engine-provider/index.html)@Injectconstructor(applicationEnvironment: ApplicationEnvironment) : Provider&lt;ApplicationEngine&gt; |
| [ApplicationEnvironmentProvider](-application-environment-provider/index.html) | [jvm]<br>class [ApplicationEnvironmentProvider](-application-environment-provider/index.html)@Injectconstructor(args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) : Provider&lt;ApplicationEnvironment&gt; |
| [DatabaseConfigurationProvider](-database-configuration-provider/index.html) | [jvm]<br>class [DatabaseConfigurationProvider](-database-configuration-provider/index.html)@Injectconstructor(applicationEnvironment: ApplicationEnvironment) : Provider&lt;DatabaseConfiguration&gt; |
| [ShutdownHook](-shutdown-hook/index.html) | [jvm]<br>class [ShutdownHook](-shutdown-hook/index.html)(logger: Logger, applicationEngine: ApplicationEngine, database: HikariDatabase) : [Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) |
| [WebModule](-web-module/index.html) | [jvm]<br>class [WebModule](-web-module/index.html)(args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) : KotlinModule |


## Functions


| Name | Summary |
|---|---|
| [main](main.html) | [jvm]<br>fun [main](main.html)(args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) |

