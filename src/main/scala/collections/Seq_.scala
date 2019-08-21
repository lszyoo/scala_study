package collections

/**
  * Seq 是所有序列的根，不能实例化
  *
  * 序列类型：
  * Seq             所有序列的根类型，List() 的快捷方式
  * -|IndexedSeq    索引序列的根类型，Vector() 的快捷方式
  *  |-Vector       这一类列表有一个后备Array实例，可以按索引访问（查询快，增删慢）
  *  |-Range        整数范围，动态生成数据
  * -|LinearSeq     线性（链表）序列的根类型
  *  |-List         元素的单链表（查询慢，增删快）
  *  |-Queue        先进先出（FIFO）列表
  *  |-Stack        后进先出（LIFO）列表
  *  |-Stream       懒列表，访问元素时才增加相应元素
  *
  * String    字符集合
  */
object Seq_ extends App {
  // 创建 List
  val inks = Seq('C', 'M', 'Y', 'K')
  println(inks)
  // 输出：List(C, M, Y, K)


  // ++ 和 take 来自于 Iterable
  val hi = "Hello, " ++ "worldly" take 12 replaceAll("w", "W")
  println(hi)
  // 输出：Hello, World


  /**
    * Stream 是一个懒集合，由一个或多个起始元素和一个递归函数生成，第一次访问元素时才会把这个元素增加到集合中，
    * 流可以以 Stream.Empty 结束，对应于 List.Nil
    */
  // 无界
  def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i + 1))
  val s = inc(1)
  println(s)
  // 输出：Stream(1, ?)
  val l = s.take(5).toList
  println(l)
  // 输出：List(1, 2, 3, 4, 5)
  println(s)
  // 输出：Stream(1, 2, 3, 4, 5, ?)

  def inc1(head: Int): Stream[Int] = head #:: inc(head + 1)
  println(inc1(10).take(10).toList)
  // 输出：List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)


  // 有界
  def to(head: Char, end: Char): Stream[Char] = (head > end) match {
    case true => Stream.Empty
    case false => head #:: to((head + 1).toChar, end)
  }
  println(to('A', 'F').take(20).toList)
  // 输出：List(A, B, C, D, E, F)
}
