# README #

### Wordcount ###

Description: Default "Hello World!!!" application for Big Data, i.e. counting the words in a huge file 

```
#!bash

sbt stage
```


```
#!bash

<SPARK_HOME>/bin/spark-submit --class com.kasured.spark.wordcount.Bootstrap \ 
--master local[4] --conf "spark.executor.memory=756m" \ 
<local_path>/home/kasured/coding/scala/handson-spark/wordcount/target/scala-2.11/wordcount_2.11-1.0.0.jar \ 
<local_path_to_huge_txt_input_file> <local_path_to_result_output_file>
```


