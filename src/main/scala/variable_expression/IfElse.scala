package variable_expression

/**
  * Write by Brain on 2019/05/30.
  *
  *
  * scala 中 只支持一个 "if" 和 可选的 "else" 块，而不识别 "else if" 块
  * if...else if...else 等价于 if...else {if...else} 嵌套
  */
object IfElse extends App {
  val result = if (true) "The result is One!"
  println(result)
  // 输出：The result is One!

  val x = 10
  val y = 20
  val max = if (x > y) x else y
  println(max)
  // 输出：20
}
