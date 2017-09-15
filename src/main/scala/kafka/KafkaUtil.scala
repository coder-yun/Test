package kafka

import java.util
import java.util.Properties

import kafka.consumer.{Consumer, ConsumerConfig}
import kafka.utils.ZkUtils

import scala.collection.mutable
import scala.collection.JavaConverters._

/**
  * Created by caiyunwu on 2017/6/12.
  */
object KafkaUtil {
  def main(args: Array[String]): Unit = {
    val prop=new Properties();
    prop.put("metadata.broker.list","gzns-waimai-do-impala334.gzns.iwm.name:8092")
    prop.put("group.id", "druid-test-sak4")
    prop.put("zookeeper.connect", "gzns-waimai-do-impala334.gzns.iwm.name:8181");
    prop.put("auto.offset.reset", "smallest");
    val topic="druid_waimai_log_fact_log_details_errorlog_v1"

    val conf=new ConsumerConfig(prop)
    val consumerConnector =Consumer.create(conf)
    val topicMap= Map[String,Int]((topic,1))

    val kafkaStreams=consumerConnector.createMessageStreams(topicMap)
    val kafkaStream =  kafkaStreams.get(topic).get(0)
    val iterator= kafkaStream.iterator()

    println("start comsumer")
    var num=0;
    while(iterator.hasNext()) {
      num+=1;
      val  msg= new String(iterator.next().message())
      println(num+":"+msg)
    }



  }
}
