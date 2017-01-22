package com.yun.regex

object NBSParser {
  val bns = "group.es-antispam.iwaimai.gzhxy"

  val rex = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))".r
  def main(args: Array[String]): Unit = {
    val rex2 = "[a-zA-Z]".r
    if (rex2.findFirstIn(bns).isDefined) {
      parserBNS(bns)
    }
  }

  def parserBNS(bns: String): (String, String) = {
    import sys.process._
    val bnsMsgs: String = s"get_instance_by_service -a ${bns}"!!
    val bnsMsgList = bnsMsgs.split("\\n")
    val ips = bnsMsgList.map(_.split(" ")(1)).mkString(",")
    val port = bnsMsgList(0).split(" ")(3)
    (ips, port)
  }

}