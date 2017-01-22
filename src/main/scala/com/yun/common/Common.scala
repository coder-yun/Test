package com.yun.common

/**
  * Created by caiyunwu on 1/12/17.
  */
object Common {
  def main(args: Array[String]): Unit = {
    testStream
  }

   def testStream = {
    val v = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val stream = v.toStream.map(_ * 10)
    println(s"stream = ${stream.tail}")
    println(s"stream = ${stream.tail}")
    println(s"stream = ${stream.take(3).force}")
  }
}
