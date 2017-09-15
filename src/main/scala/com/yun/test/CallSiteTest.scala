package com.yun.test

import scala.collection.mutable.ArrayBuffer

/**
  * Created by caiyunwu on 2017/9/14.
  */
object CallSiteTest {

  def test1() = {
    val callStack=new ArrayBuffer[String]()
    Thread.currentThread().getStackTrace().foreach { ste: StackTraceElement =>
        callStack+=ste.toString
    }
    println(callStack.mkString("\n"))
  }

  def main(args: Array[String]): Unit = {
    test1();
  }
}
