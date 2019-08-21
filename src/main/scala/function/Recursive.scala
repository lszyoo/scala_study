package function

/**
  * 使用递归函数的一个问题是可能会遇到致命的"栈溢出"错误，这表明调用一个递归函数的次数太多，耗尽了所有已分配的栈空间。
  *
  * 尾递归优化：
  *   只是用当前函数的空间，不使用额外的栈空间。
  *   只有最后一句是递归调用的函数才能由Scala编译器完成尾递归优化
  */
object Recursive extends App {
  def power(x: Int, y: Int): Long = {
    if (y >= 1) x * power(x, y - 1)
    else 1
  }
  println(power(2, 8))
  // 输出：256


  // 注解函数标志尾递归化
  @annotation.tailrec
  def power1(x: Int, y: Int, t: Int = 1): Long = {
    // t 是结果
    if (y < 1) t
    else power1(x, y - 1, x * t)
  }
  println(power1(2, 8))
  // 输出：256
}
