import sbt.Keys._

import Dependencies._

lazy val commonSettings = Seq(

  version := "1.0.0",

  scalaVersion := "2.11.6",

  scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.7",
    "-deprecation", "-feature", "-unchecked",
    "-Xlog-reflective-calls",
    "-Xlint"
  ),

  javaOptions in run ++= Seq(
    "-Xms128m", "-Xmx1024m",
    "-XX:PrintGCDetails", "-XX:PrintGCDateStamps", "-Xloggc:akka-cluster-log.gc"
  ),

  Keys.fork in run := true,

  resolvers ++= Dependencies.reolutiionRepos

)

lazy val root = project.in(file("."))
  .aggregate(wordcount)
  .settings(commonSettings: _*)

lazy val wordcount = project.in(file("wordcount"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= spark_deps)
  .settings(mainClass in Compile := Some("com.kasured.spark.wordcount.Bootstrap"))

