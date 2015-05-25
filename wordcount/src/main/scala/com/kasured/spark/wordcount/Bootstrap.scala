package com.kasured.spark.wordcount

import org.apache.spark.{SparkContext, SparkConf}


/**
 * @author kasured.
 */
object Bootstrap {
  def main(args: Array[String]): Unit = {

    val inputFile = args(0)
    val outputFile = args(1)

    println(s"Input file: $inputFile\nOutput file: $outputFile")

    val sparkConfig = new SparkConf().setAppName("wordcount")
    val sc = new SparkContext(sparkConfig)

    val baseRDD = sc.textFile(inputFile)

    val counts = baseRDD.flatMap(_ split " ").map ((_, 1))
      .reduceByKey((count1, count2) => count1 + count2)
      .map(_.swap)
      .sortByKey(ascending = false,1)
      .map(_.swap)

    counts saveAsTextFile outputFile

  }
}
