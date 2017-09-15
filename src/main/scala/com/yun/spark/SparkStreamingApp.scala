package com.yun.spark


import com.yun.kafka.KafkaUtil
import kafka.serializer.DefaultDecoder
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Duration, StreamingContext}
import org.apache.spark.SparkConf

/**
  * Created by caiyunwu on 2017/6/30.
  */
object SparkStreamingApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("parse_pb")
    val ssc = new StreamingContext(sparkConf, new Duration(10))

    var kafkaParam = Map[String, String]()
    kafkaParam += ("group.id" -> "test_kafka3")
    kafkaParam += ("metadata.broker.list" -> "gzns-waimai-do-impala334.gzns.iwm.name:8092")
    kafkaParam += ("zookeeper.connect" -> "gzns-waimai-do-impala334.gzns.iwm.name:8181")
    kafkaParam += ("auto.offset.reset" -> "smallest")
    val topics = "create_topic".split(',').toSet

    val inputStream = KafkaUtils.createDirectStream[Array[Byte], Array[Byte], DefaultDecoder, DefaultDecoder](ssc, kafkaParam, topics)

    inputStream
      .map(kv => new String(kv._2))
      .foreachRDD { rdd =>
          val topic = "druid_waimai_log_fact_log_sak5"
          println("check topic:%s, partitions:%s,replications:%s".format(topic, 20, 1))
        KafkaUtil.createTopicIfNotExsit("gzns-waimai-do-impala334.gzns.iwm.name:8181", topic, 20, 1);
        println("total message:"+rdd.count())
        rdd.collect.foreach(value => println("value:" + value))
      }

    ssc.start()
    ssc.awaitTermination()

  }
}
