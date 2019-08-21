package function

/**
  * 部分应用函数和柯里化
  */
object Currying extends App {
  // 函数类型为：(Int, Int) => Boolean
  def factorOf(x: Int, y: Int) = y % x == 0
  // 通配符赋值
  val f = factorOf _
  println(f(7, 20))
  // 输出：false

  // 部分应用函数
  val multipleOf = factorOf(3, _: Int)
  println(multipleOf(6))
  // 输出：true


  /**
    * 函数柯里化
    */
  // 函数类型为：Int => Int => Boolean
  def factorOf1(x: Int)(y: Int) = y % x == 0
  val isEven = factorOf1(2) _
  println(isEven(3))
  // 输出：false
}
