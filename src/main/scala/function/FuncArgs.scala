package function

object FuncArgs extends App {
  /**
    * 按不按顺序写参均可
    */
  def greet(prefix: String, name: String) = s"$prefix $name"
  val gr1 = greet("Ms", "Brown")    // 按顺序
  println(gr1)
  // 输出：Ms Brown
  val gr2 = greet(name = "Brown", prefix = "Ms")  // 不按顺序
  println(gr2)
  // 输出：Ms Brown


  /**
    * 默认值参数
    */
  def greet1(prefix: String = "", name: String) = s"$prefix$name"
  println(greet1(name = "Paul"))
  // 输出：Paul


  /**
    * vararg 参数
    */
  def sum(items: Int*): Int = {
    var total = 0
    for (i <- items) total += i
    total
  }
  println(sum(10, 20, 30))
  // 输出：60


  /**
    * 参数组
    */
  def max(x: Int)(y: Int) = if (x > y) x else y
  println(max(20)(39))
  // 输出：39


  /**
    * 类型参数：
    *   def <function-name>[type-name](<parameter-name>: <type-name>): <type-name>...
    */
  def identify[A](a: A): A = a
  val s: String = identify[String]("hello")
  val s1: String = identify("world")    // scala能自己推到类型
  println(s + " " + s1)
  // 输出：hello world


  /**
    * 传名参数：
    *   <identifier>: => <type>
    *
    * 如果传名参数是一个函数，那么每次在方法中访问这个参数时都会调用这个函数。倘若不访问这个参数，就不会调用这个函数
    */
  def dou(x: => Int) = {
    println("now " + x)
    x * 2
  }
  println(dou(5))
  // 输出：now 5
  //      10

  def f(i: Int) = {
    println(s"Hello from f($i)")
    i
  }

  println(dou(f(8)))
  /*
    输出：
          Hello from f(8)
          now 8
          Hello from f(8)
          16
   */
}
