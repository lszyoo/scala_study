package collections

import java.util

import collection.JavaConverters._

object JavaScala extends App {
  // asJava   将这个Scala集合转换为相应的Java集合
  val l1 = List(12, 29).asJava

  // asScala    将这个Java集合转换为相应的Scala集合
  val l2 = new util.ArrayList(5).asScala
}
