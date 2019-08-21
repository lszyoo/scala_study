package collections

object ListTranform extends App {
  val l1 = List(99, 24, 104)

  // mkString   使用给定分隔符将一个集合呈现为 String
  println(l1.mkString(", "))
  // 输出：99, 24, 104

  // toString   将一个集合呈现为String，包括集合类型
  println(l1.toString())
  // 输出：List(99, 24, 104)

  // toBuffer   将一个不可变的集合转换成一个可变的集合
  println(l1.toBuffer)
  // 输出：ArrayBuffer(99, 24, 104)

  // toList   将一个集合转换成一个List
  println(Map("a" -> 1, "b" -> 2).toList)
  // 输出：List((a,1), (b,2))
  println(Set(1, 3, 3, 2).toList)
  // 输出：List(1, 3, 2)

  // toMap    将一个2元元组（长度为2）的集合转换为一个Map
  println(Set(1 -> true, 2 -> false).toMap)
  // 输出：Map(1 -> true, 2 -> false)
  println(List((1, "a"), (2, "b")).toMap)
  // 输出：Map(1 -> a, 2 -> b)

  // toSet    将一个集合转换为Set
  println(List(2, 3, 4, 2).toSet)
  // 输出：Set(2, 3, 4)
  println(Map("a" -> 1, "b" -> 2, "b" -> 3).toSet)
  // 输出：Set((a,1), (b,3))
}
