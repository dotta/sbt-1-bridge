# README

This project serves the purpose of demonstrating the issue I'm experiencing when setting the `scalaCompilerBridgeSource`. To see the problem, clone this repository and publish locally the `sbt-bridge` project:

```
$ sbt
sbt:sbt-1-bridge> sbt-bridge/publishLocal
[...]
[info] 	delivering ivy file to /Users/mirco/tmp/sbt-1-bridge/sbt-bridge/target/ivy-0.1.0-SNAPSHOT.xml
[info] 	published sbt-bridge to /Users/mirco/.ivy2/local/com.github.dotta/sbt-bridge/0.1.0-SNAPSHOT/poms/sbt-bridge.pom
[info] 	published sbt-bridge to /Users/mirco/.ivy2/local/com.github.dotta/sbt-bridge/0.1.0-SNAPSHOT/jars/sbt-bridge.jar
[info] 	published sbt-bridge to /Users/mirco/.ivy2/local/com.github.dotta/sbt-bridge/0.1.0-SNAPSHOT/srcs/sbt-bridge-sources.jar
[info] 	published sbt-bridge to /Users/mirco/.ivy2/local/com.github.dotta/sbt-bridge/0.1.0-SNAPSHOT/docs/sbt-bridge-javadoc.jar
[info] 	published ivy to /Users/mirco/.ivy2/local/com.github.dotta/sbt-bridge/0.1.0-SNAPSHOT/ivys/ivy.xml
[success] Total time: 12 s, completed Aug 28, 2017 12:43:42 PM
```

In case you wonder, the `sbt-bridge` project contains the exact same sources as [`zinc/compiler-bridge`](https://github.com/sbt/zinc/tree/1.x/internal/compiler-bridge).

Quit sbt and `cd` to the `playground` folder. Then enter `sbt` on the playground project and hit `compile`:

```
$ cd playground/
$ sbt
[info] Loading settings from plugins.sbt ...
[info] Loading project definition from /Users/mirco/tmp/sbt-1-bridge/playground/project
[info] Loading settings from build.sbt ...
[info] Set current project to playground (in build file:/Users/mirco/tmp/sbt-1-bridge/playground/)
[info] sbt server started at 127.0.0.1:5815
sbt:playground> compile
[info] Compiling 1 Scala source to /Users/mirco/tmp/sbt-1-bridge/playground/target/scala-2.12/classes ...
[info] Attempting to fetch com.github.dotta:sbt-bridge:0.1.0-SNAPSHOT.
[error] ## Exception when compiling 1 sources to /Users/mirco/tmp/sbt-1-bridge/playground/target/scala-2.12/classes
[error] Cannot add dependency 'com.github.dotta#sbt-bridge;0.1.0-SNAPSHOT' to configuration 'component' of module org.scala-sbt.temp#temp-module-1085eee86f1859846be244e342adb48e7f9cb5ab;0.1.0-SNAPSHOT because this configuration doesn't exist!
[...]
```

Am I missing something obvious, or is there a problem with how the `component` configuration is handled in sbt 1.0.0?