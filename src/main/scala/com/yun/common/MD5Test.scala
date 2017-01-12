package com.yun.common

import java.math.BigInteger
import java.security.MessageDigest

/**
  * Created by caiyunwu on 1/12/17.
  */
object MD5Test {
  def main(args: Array[String]): Unit = {
    getMD5("xuxueasdfa")
  }

  private def getMD5(str:String) = {
    val bytes=str.getBytes("UTF-8")
    val msgDigest = MessageDigest.getInstance("MD5")
    msgDigest.update(bytes)
    val res=msgDigest.digest()
    val resStr=new BigInteger(res).toString(16)
    println(s"resStr = ${resStr}")
  }
}
