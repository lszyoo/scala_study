package function

/**
  * 高阶函数，如：map()、reduce()
  */
object HigherOrder extends App {
  // f 为函数值参数
  def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }

  def reverser(s: String) = s.reverse

  println(safeStringOp(null, reverser))
  // 输出：null
  println(safeStringOp("Ready", reverser))
  // 输出：ydaeR


  /**
    * 用函数字面量块调用高阶函数
    */
  val uuid = java.util.UUID.randomUUID().toString
  val timedUUID = safeStringOp(uuid, { s =>
    val now = System.currentTimeMillis()
    val timed = s.take(24) + now    // 取前24位
    timed.toUpperCase()
  })
  println(timedUUID)
  // 输出：8DC0F7CF-47C8-4367-961A-1559522331466

  // 改进
  def safeStringOp1(s: String)(f: String => String) = {
    if (s != null) f(s) else s
  }
  val timedUUID1 = safeStringOp1(uuid) { s =>
    val now = System.currentTimeMillis()
    val timed = s.take(24) + now    // 取前24位
    timed.toUpperCase()
  }
  println(timedUUID1)
  // 输出：CA825F03-2E88-4A1F-824F-1559522439428


  // 使用一个类型参数作为传名参数返回类型以及主函数的返回类型
  def timer[A](f: => A): A = {
    def now = System.currentTimeMillis()
    val start = now
    val a = f
    val end = now
    println(s"Executed in ${end - start}ms")
    a
  }

  // 调用函数，{} 花括号相当于函数timer中()的参数
  val veryRandomAmount = timer {
    util.Random.setSeed(System.currentTimeMillis())
    for (i <- 1 to 1000) util.Random.nextDouble()
    util.Random.nextDouble
  }
  println(veryRandomAmount)
  /*
    输出：Executed in 8ms
         0.35452488066810417
   */
}
