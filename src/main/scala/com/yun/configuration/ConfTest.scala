package com.yun.configuration

import com.typesafe.config.{Config, ConfigException, ConfigFactory}

import scala.collection.JavaConverters._

object ConfSettings {
  val conf = ConfigFactory.load()

  private def getObjectToMap(name: String): Map[String, String] = getObjectToMap(name, conf)
  private def getObjectToMap(name: String, specialConf: Config): Map[String, String] = specialConf.getConfig(name).entrySet().asScala.map { kv => kv.getKey -> kv.getValue.unwrapped().toString() }.toMap

  val isTest = true
  val productionConf = { if (isTest) conf.getConfig("test") else conf.getConfig("production") }

  val kafkaConf = getObjectToMap("kafkaConf", productionConf)
  val esConf = getObjectToMap("esConf", productionConf)
  val antiSpamFieldsSet = productionConf.getString("antiSpamFields").split(",").toSet
  val batchDurationSeconds = productionConf.getLong("batchDurationSeconds")
  val applicationName = productionConf.getString("applicationName")

  private def getConfigToMap(name: String): Map[String, String] = getConfigToMap(name, conf)

  private def getConfigToMap(name: String, specialConf: Config): Map[String, String] = {
    val configMap = try {
      specialConf.getConfig(name).entrySet().asScala.map { kv => kv.getKey -> kv.getValue.unwrapped().toString }.toMap
    } catch {
      case empty: ConfigException.Missing => Map[String, String]()
      case err: Throwable => throw err
    }
    configMap
  }

  override def toString: String = {
    conf.entrySet().asScala.map { kv => s"${kv.getKey} : ${kv.getValue.unwrapped().toString()}" }.toBuffer.sorted.mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    println(kafkaConf.get("rebalance.max.retries"))
    println(conf)
  }

}

