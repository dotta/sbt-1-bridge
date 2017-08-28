organization in ThisBuild := "com.github.dotta"
version in ThisBuild := "0.1.0-SNAPSHOT"

val ZincVersion = "1.0.0-X20"

val scalaPartialVersion = Def setting (CrossVersion partialVersion scalaVersion.value)

val scalaCompiler = Def.setting { "org.scala-lang" % "scala-compiler" % scalaVersion.value }

lazy val `sbt-bridge` = (project in file("sbt-bridge"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-sbt" % "compiler-interface" % ZincVersion % "provided",
      scalaCompiler.value % "provided"
    ),
    inBoth(unmanagedSourceDirectories ++= scalaPartialVersion.value.collect {
      case (2, y) if y == 10 => new File(scalaSource.value.getPath + "_2.10")
      case (2, y) if y >= 11 => new File(scalaSource.value.getPath + "_2.11+")
    }.toList),
    crossPaths := false
  )

def inBoth(ss: Setting[_]*): Seq[Setting[_]] = Seq(Compile, Test) flatMap (inConfig(_)(ss))