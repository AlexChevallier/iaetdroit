name := "jp_annotation"
organization := "org.els"
version := "1.0"

scalaVersion := "2.12.2"

cancelable in Global := true

val scalatest = "3.0.3"
val akkaVersion = "2.5.3"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6" withSources () withJavadoc (),
  "com.typesafe.akka" %% "akka-stream" % akkaVersion withSources () withJavadoc (),
  "com.typesafe" % "config" % "1.3.1" withSources () withJavadoc (),
  "ch.qos.logback" % "logback-classic" % "1.2.3" withSources () withJavadoc (),
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1",
  ("org.scalatest" %% "scalatest" % scalatest % "test")
    .withSources()
    .withJavadoc(),
  ("org.scalactic" %% "scalactic" % scalatest).withSources().withJavadoc()
)

unmanagedBase := baseDirectory.value / "lib"

scalacOptions ++= Seq("-unchecked",
  "-deprecation",
  "-feature",
  "-language:implicitConversions")

fork in run := true

javaOptions in run ++= Seq(
  "-Xmx10G", "-Xms10g", "-XX:MaxPermSize=10g"
)
