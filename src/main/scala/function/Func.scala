package function

object Func extends App {
  /**
    * 无输入函数：
    *   def <identifier> = <expression>
    */
  def hi = "hi"
  println(hi)      // 调用不可加 ()
  // 输出：hi

  def hi1() = "hi1"
  println(hi1(), hi1)     // 调用 () 可加可不加
  // 输出：(hi1,hi1)

  /**
    * 指定返回类型：
    *   def <identifier>: <type> = <expression>
    */
  def hello: String = "hello"
  println(hello)
  // 输出：hello


  /**
    * 默认返回函数最后一行，但若遇到 return 则返回
    * 过程：没有返回值的函数
    */
  def multiplier(x: Int, y: Int): Int = {
    x * y
  }
  println(multiplier(3, 4))
  // 输出：12

  def safeTrim(s: String): String = {
    if (s == null)
      return null
    s.trim()
  }
  println(safeTrim(null), safeTrim("ab c"))
  // 输出：(null,ab c)

  def log(d: Double) = println(f"Got value $d%.2f")
  def log1(d: Double): Unit = f"Got value $d%.2f"
  println(log(2))
  /*
    输出：Got value 2.00
         ()
   */
  println(log1(3))
  // 输出：()


  /**
    * 用表达式块调用函数：
    *   <function identifier> <expression block>
    * 表达式块会在调用函数之前计算，并且表达式块的返回值将作为这个函数的参数。
    */
  def formatEuro(amt: Double) = f" $amt%.2f"
  val fom = formatEuro {
    val rate = 1.32
    0.235 + 0.713 + rate * 5.32
  }
  println(fom, formatEuro(3.4645))
  // 输出：( 7.97, 3.46)


  /**
    * 给函数赋值
    * 函数类型：
    *   ([<type>, ...]) => <type>
    *
    * func1 值必须有显式的类型，以区分它是一个函数值，而不是一个函数调用。单个参数的函数类型可省略小括号，如：Int => Int
    * 定义函数值以及用函数赋值的另一种做法是使用通配符 _
    */
  def func(x: Int): Int = x * 2
  val func1: (Int) => Int = func
  val func2 = func1
  println(func(5) + " " + func1(5) + " " + func2(5))
  // 输出：10 10 10

  def max(a: Int, b: Int) = if (a > b) a else b
  val maximize: (Int, Int) => Int = max
  println(maximize(10, 9))
  // 输出：10

  // 函数无参
  def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50
  val start: () => String = logStart
  println(start())    // 注意调用必须加小括号
  /*
    输出：
        ==================================================
        Starting NOW
        ==================================================
   */


  /**
    * 用通配符给函数赋值：
    *   val <identifier> = <function name> _
    */
  val func3 = func _
  println(func3(6))
  // 输出：12

  val maxmi = max _
  println(maxmi(4, 9))
  // 输出：9

  val stat = logStart _
  println(stat())
  /*
    输出：
        ==================================================
        Starting NOW
        ==================================================
   */



}
