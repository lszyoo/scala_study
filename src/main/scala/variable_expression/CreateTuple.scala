package variable_expression

/**
  * Write by Brain on 2019/05/30.
  */
object CreateTuple extends App {
  val info = (5, "Korben", true)
  println(info._1)
  // 输出：5

  // 创建大小为 2 的元组
  val person = "LiMing" -> "man"
  println(person)
  // 输出：(LiMing,man)
}
