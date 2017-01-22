package com.yun.log

object LoggerTest extends LoggerTrait {
  def main(args: Array[String]): Unit = {
    logInfo("hello LogTest")
//    methodLog
    val map = Map("1" -> 1, "2" -> 2, "3" -> 3)
    logInfo(map.mkString("\n"))
    log.info("{}",getString(map))
        try{
    val a=Array(1,2,3)
    val b=a(10)
        }catch{
          case e:Throwable=>logInfo("",e);
        }
  }

  def methodLog {
    println("methodLog test")
    val msgList = List("list1", "list2", "list3")
    logDebug(msgList.map { x=>logInfo("msg action") ;x}.mkString(","))
    logError("err log")
    logInfo("info log")

  }
  def getString(map:Map[String,Int])={
    val re=map.mkString("||||")
    println(s"re = ${re}")
    re
  }
}