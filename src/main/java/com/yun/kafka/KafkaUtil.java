package com.yun.kafka;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;
import org.I0Itec.zkclient.ZkClient;

import java.util.Properties;

/**
 * Created by caiyunwu on 2017/6/30.
 */
public class KafkaUtil {
    public static void main(String[] args) {
        String zkConnect = "gzns-waimai-do-impala334.gzns.iwm.name:8181";
        int zkSessionTimeout = 60000;
        int zkConnectTimeout = 60000;
        String topic = "create_topic";
//        String topic = "test_topic_create";

        createTopicIfNotExsit(zkConnect, zkSessionTimeout, zkConnectTimeout, topic, 3, 1);


    }

    public static void createTopicIfNotExsit(String zkConnect, int zkSessionTimeout, int zkConnectTimeout, String topic, int partitions, int replicationFactor) {
        ZkClient zkClient = new ZkClient(zkConnect, zkSessionTimeout, zkConnectTimeout, ZKStringSerializer$.MODULE$);
        if (!zkClient.exists(ZkUtils.getTopicPath(topic))) {
            AdminUtils.createTopic(zkClient, topic, partitions, replicationFactor, new Properties());
        } else {
            System.out.println("topic " + topic + " exists");
        }
        zkClient.close();
    }

    public static void createTopicIfNotExsit(String zkConnect, int zkSessionTimeout, int zkConnectTimeout, String topic) {
        createTopicIfNotExsit(zkConnect, zkSessionTimeout, zkConnectTimeout, topic, 20, 1);
    }

    public static void createTopicIfNotExsit(String zkConnect, String topic) {
        createTopicIfNotExsit(zkConnect, 3000, 3000, topic);
    }


    public static void createTopicIfNotExsit(String zkConnect, int zkSessionTimeout, int zkConnectTimeout, String topic, int partitions) {
        createTopicIfNotExsit(zkConnect, zkSessionTimeout, zkConnectTimeout, topic, partitions, 3);
    }


    public static void createTopicIfNotExsit(String zkConnect, String topic, int partitions, int replicationFactor) {
        createTopicIfNotExsit(zkConnect, 3000, 3000, topic, partitions, replicationFactor);
    }

    public static void createTopicIfNotExsit(String zkConnect, String topic, int partitions) {
        createTopicIfNotExsit(zkConnect, 3000, 3000, topic, partitions);
    }
}
