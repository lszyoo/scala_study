package collections

import java.io.File

/**
  * Array：隐含类，不在集合包中，但可以像序列一样使用
  * 是一个大小固定的可变索引集合
  */
object Array_  extends App {
  val colors = Array("red", "green", "blue")
  println(colors)
  // 输出：[Ljava.lang.String;@13969fbe

  // 替换对应索引的值
  colors(0) = "purple"

  // File[] 数组
  val files = new File(".").listFiles()

  //
  val scala = files.map(_.getName).filter(_.endsWith("scala"))
}
