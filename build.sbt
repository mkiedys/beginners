name := "LoveScala"

organization := "io.scalac"

scalaVersion := "2.11.6"

scalacOptions ++= Seq(
  "-unchecked", "-deprecation", "-feature", "-Xfatal-warnings", "-target:jvm-1.7"
)

libraryDependencies ++= Seq(
  "org.scalacheck"    %% "scalacheck" % "1.12.3" % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11"
)