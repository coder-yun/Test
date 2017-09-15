package com.yun.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by caiyunwu on 2017/6/11.
 */
public class MyKafkaProducer {
    private final static Producer<String, String> producer;
    private final static Logger LOG = LoggerFactory.getLogger(MyKafkaProducer.class);

    static {
        Properties props = new Properties();
        props.put("bootstrap.servers", "gzns-waimai-do-impala334.gzns.iwm.name:8092");
        props.put("acks", "1");
        props.put("retries", 4);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(props);
    }

    public static void main(String[] args) {
        String topic = "create_topic";
        for(int i=0;i<100;i++) {
            String msg="123456"+i;
            System.out.println("produce msg:"+msg);
            sendMessage(topic, "123456"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }

    public static void sendMessage(String topic, String content) {
        try {
            if (!content.equals("")) {
                ProducerRecord<String, String> message = new ProducerRecord(topic, content);
                producer.send(message);
            }
        } catch (Exception e) {
            LOG.error("topic[{}] content[{}] send to druid kafka exception {}", topic, content, e.getMessage());
        }
    }

}
