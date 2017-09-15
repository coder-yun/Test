package com.yun.common

import com.alibaba.fastjson.JSON

/**
  * Created by caiyunwu on 1/12/17.
  */
object Common {
  def main(args: Array[String]): Unit = {
//    testStream
//    testDrop
      testMap
  }
  def testMap={
    var resultMap = Map[String, Object]()
    resultMap += ("1"->"111")
    resultMap+=("2"->"222")
    resultMap+=("3"->"")
    val key ="3"

    val rulesInfo=resultMap.get(key)
    if(rulesInfo.isEmpty||rulesInfo.get.asInstanceOf[String].isEmpty){
      resultMap+=(key->Array[Int](0))
    }else{
      val rulesInfoArr=rulesInfo.map(rules=>rules.asInstanceOf[String].split(",").map(rule=>rule.toInt))
      resultMap+=(key->rulesInfoArr.get)
    }
    println(resultMap(key).getClass)
    println(resultMap(key).asInstanceOf[Array[Int]].mkString(","))
//    println(s"JSON.toJSONString(resultMap) = ${JSON.toJSONString(resultMap)}")
  }

  def testDrop={
    val list = List(1,2,3,4,5,6,7,8)
    list.dropWhile(_<4).foreach(println)
  }

   def testStream = {
    val v = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val stream = v.toStream.map(_ * 10)
     println(s"stream = ${stream.head}")
     println(s"stream = ${stream.tail}")
    println(s"stream = ${stream.tail.tail}")
    println(s"stream = ${stream.take(3).force}")
  }
}
