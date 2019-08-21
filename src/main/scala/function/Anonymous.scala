package function

/**
  * 匿名函数
  * 函数字面量
  * Lambda表达式
  *
  * ([<identifier: type>, ...]) => <expression >
  */
object Anonymous extends App {
  val m = (x: Int) => x * 2
  println(m(2))
  // 输出：4

  val log = () => "无参匿名函数"
  println(log())
  // 输出：无参匿名函数


  // f 为函数值参数
  def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }
  println(safeStringOp("name", (s: String) => s.reverse))
  // 输出：eman
  println(safeStringOp("hello", s => s.reverse))    // 函数字面量本质：通过参数的一个操作返回一个值
  // 输出：olleh


  /**
    * 占位符语法：是函数字面量的一种缩写形式，将命名参数替换为通配符(_)
    * 可在以下情况使用：
    *   （1）函数的显示类型在字面量之外指定
    *   （2）参数最多只使用一次
    */
  val x: Int => Int = _ * 2
  println(x(4))
  // 输出：8

  println(safeStringOp("world", _.reverse))
  // 输出：dlrow


  /**
    * 多个占位符：会按位置替换输入参数
    */
  def combination(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)
  println(combination(23, 10, _ * _))
  // 输出：230

  // 使用通用类型，提高灵活性
  def tripleOp[A, B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a, b, c)
  println(tripleOp[Int, Boolean](93, 92, 14, _ > _ + _))
  // 输出：false
}
