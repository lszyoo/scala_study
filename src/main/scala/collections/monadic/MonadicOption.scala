package collections.monadic

/**
  * 一元集合：包含元素不能多于一个
  *
  * Option：类安全
  *         可能存在的值
  * Some 是一个类型参数化的单元素集合，None 是一个空集合
  */
object MonadicOption extends App {
  // 用非null值和null值来创建Option
  var x: String = "Indeed"
  var a = Option(x)
  println(a)
  // 输出：Some(Indeed)
  x = null
  var b = Option(x)
  println(b)
  // 输出：None


  // 使用 isDefined 和 isEmpty 分别检查一个给定的 Option 是 Some 还是 None
  println(s"a is defined? ${a.isDefined}")
  // 输出：a is defined? true
  println(s"b is not defined? ${b.isEmpty}")
  // 输出：b is not defined? true


  // 检查分母不能为0
  def divide(amt: Double, divisor: Double): Option[Double] = {
    if (divisor == 0) None
    else Option(amt / divisor)
  }
  println(divide(2, 5))
  // 输出：Some(0.4)
  println(divide(3, 0))
  // 输出：None


  // headOption 空列表head报异常
  val odds = List(1, 3, 5)
  val firstOdd = odds.headOption
  println(firstOdd)
  // 输出：Some(1)
  val evens = odds.filter(_ % 2 == 0)
  println(evens.headOption)
  // 输出：None


  // 检查 find 是否成功
  val words = List("risible", "scavenger", "gist")
  val upperCase = words.find(w => w == w.toUpperCase)
  println(upperCase)
  // 输出：None
  val lowerCase = words.find(w => w == w.toLowerCase())
  println(lowerCase)
  // 输出：Some(risible)
  println(lowerCase.filter(_.endsWith("ble")).map(_.toUpperCase()))
  // 输出：Some(RISIBLE)
  println(lowerCase.filter(_.size > 15).map(_.size))
  // 输出：None


  // 从Option抽值：Option.get()，不安全，应使用 fold 或 getOrElse
  def nextOption = if (util.Random.nextInt > 0) Some(1) else None
  /**
    * fold        对于Some，从给定函数返回值或返回起始值，foldLeft、foldRight、reduceXXX
    * getOrElse   为Some返回值，或为None返回传名参数的结果
    * orElse      并不真正抽取值，而是试图为None填入一个值
    * 匹配表达式
    */
  val next = nextOption
  println(next.fold(-1)(x => x))
  // x = None，返回 -1；x = 1，返回 1
  println(next.foldLeft(-1)(_ + _))
  // x = None，返回 -1；x = 1，返回 0

  println(next.getOrElse(5))
  // x = None，返回 5；x = 1，返回 1
  println(next.getOrElse {  println("error"); -1  })
  // x = None，返回 -1 并打印 error；x = 1，返回 1

  println(next.orElse(Some(2)))
  // next = None，返回参数值 Some(2)；next = Some(1)，返回 Some(1)

  println(next match {
    case Some(x) => x
    case None => -1
  })
  // x = None，返回 -1；x = 1，返回 1

}
