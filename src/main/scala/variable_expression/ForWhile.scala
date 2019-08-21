package variable_expression

/**
  * Write by Brain on 2019/05/30.
  *
  *
  * to -- 包含
  * until -- 不包含
  *
  * for (<identifier> <- <iterator>) [yield] [<expression>]
  *
  * for后接大括号或者小括号，大括号：一行代表一个迭代器，小括号：每个迭代器以分号隔开
  */
object ForWhile extends App {
  for (x <- 1 to 7) {
    println(s"Day $x")
  }
  /*输出：
      Day 1
      Day 2
      Day 3
      Day 4
      Day 5
      Day 6
      Day 7
   */


  val m = for (x <- 1 to 7) yield {
    s"$x"
  }
  println(m)
  // 输出：Vector(1, 2, 3, 4, 5, 6, 7)


  for (day <- 1 to 7) print("Day " + day + ",")
  // 输出：Day 1,Day 2,Day 3,Day 4,Day 5,Day 6,Day 7,
  println()


  /**
    * 迭代器哨卫：
    *   for (<identifier> <- <iterator> if <Boolean expression>)...
    */
  val three = for (i <- 1 to 20 if i % 3 == 0) yield i
  println(three)
  // 输出：Vector(3, 6, 9, 12, 15, 18)


  val qupte = "Faith,Hope,,Charity"
  for {
    t <- qupte.split(",")
    if t != null
    if t.size > 0
  } {
    println(t)
  }
  /*
    输出：
      Faith
      Hope
      Charity
   */


  /**
    * 嵌套迭代器
    */
  for {
    x <- 1 to 2
    y <- 1 to 3
  } {
    println(s"($x, $y)")
  }
  /*
    输出：
      (1, 1)
      (1, 2)
      (1, 3)
      (2, 1)
      (2, 2)
      (2, 3)
   */


  /**
    * 值绑定：
    *   for (<identifier> <- <iterator>; <identifier> = <expression>)...
    *
    *  yield:
    *      (1)针对每一次 for 循环的迭代, yield 会产生一个值，被循环记录下来 (内部实现上，像是一个缓冲区).
    *      (2)当循环结束后, 会返回所有 yield 的值组成的集合.
    *      (3)返回集合的类型与被遍历的集合类型是一致的.
    */
  val powersOf2 = for (i <- 1 to 8; pow = 1 << i) yield pow
  println(powersOf2)
  // 输出：Vector(2, 4, 8, 16, 32, 64, 128, 256)


  /**
    * while循环：
    *   while(<Boolean expression>) statement
    */
  var x = 10
  while (x > 0) x -= 1


  val n = 0
  do println(s"Here I am, n = $n") while (n > 0)
  // 输出：Here I am, n = 0
}
