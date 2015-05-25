import sbt._


object Dependencies {

  import Versions._


  val reolutiionRepos = Seq(
    //"Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
  )

  val spark_core = "org.apache.spark" %% "spark-core" % Spark % "provided"

  val spark_deps = Seq(spark_core)

}