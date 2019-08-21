package variable_expression

/**
  * Write by Brain on 2019/05/30.
  */
object ExpressionBlock extends App {

  val x = 5 * 20; val amount1 = x + 10
  println(amount1)
  // 输出：110

  // 表达式块中的最后一个表达式将作为整个表达式块的返回值
  val amount2 = {
    val x = 5 * 20
    x + 10
  }
  println(amount2)
  // 输出：110

  val amount3 = {
    val a = 1; {
      val b = a * 2; {
        val c = b + 4
        c
      }
    }
  }
  println(amount3)
  // 输出：6
}
