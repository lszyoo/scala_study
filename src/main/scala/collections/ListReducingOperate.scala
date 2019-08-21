package collections

/**
  * 列表的归约
  */
object ListReducingOperate extends App {
  /**
    * 数学归约
    */
  val l1 = List(3, 5, 1, 9.1)
  // max  最大值
  println(l1.max)
  // 输出：9.1

  // min  最小值
  println(l1.min)
  // 输出：1.0

  // product  积
  println(l1.product)
  // 输出：136.5

  // sum  和
  println(l1.sum)
  // 输出：18.1


  /**
    * 布尔归约
    */
  val l2 = List(12, 13, 45, 13)
  // contains   检查是否包含某个元素
  println(l2.contains(12))
  // 输出：true

  // endsWith   检查是否以某个队列结尾
  println(l2.endsWith(List(13)))
  // 输出：true

  // exists   检查判断条件是否对列表中的一个元素成立
  println(l2.exists(_ < 12))
  // 输出：false

  // forall   检查判断条件是否对列表中的每一个元素都成立
  println(l2.forall(_ > 20))
  // 输出：false

  // startsWith   检查是否以某个队列开头
  println(l2.startsWith(List(12, 13)))
  // 输出：true


  /**
    * 通用列表归约操作
    */
  val l3 = List(1, 2, 3)
  // fold   给定一个起始值和一个归约函数来归约列表（无方向）
  println(l3.fold(1)(_ + _))
  // 输出：7

  // foldLeft   给定一个起始值和一个归约函数从左到右归约列表
  println(l3.foldLeft(2)(_ + _))
  // 输出：8

  // 实现 contains
  val included = List(46, 19, 23).foldLeft(false){(a, i) => if (a) a else (i == 19)}

  // foldRight    给定一个起始值和一个归约函数从右到左归约列表
  println(l3.foldRight(3)(_ + _))
  // 输出：9

  // reduce   给定一个归约函数，从列表的第一个元素开始归约列表（无方向）
  println(l3.reduce(_ + _))
  // 输出：6

  // reduceLeft   给定一个归约函数，从列表的第一个元素开始从左到右归约列表
  println(l3.reduceLeft(_ + _))
  // 输出：6

  // reduceRight    给定一个归约函数，从列表的第一个元素开始从右到左归约列表
  println(l3.reduceRight(_ + _))
  // 输出：6

  // scan   取一个起始值和一个归约函数，返回各个累加值的一个列表
  println(l3.scan(0)(_ + _))
  // 输出：List(0, 1, 3, 6)

  // scanLeft   取一个起始值和一个归约函数，从左到右返回各个累加值的一个列表
  println(l3.scanLeft(0)(_ + _))
  //           0, 1, 2, 3
  // 输出：List(0, 1, 3, 6)

  // scanRight    取一个起始值和一个归约函数，从右到左返回各个累加值的一个列表
  println(l3.scanRight(0)(_ + _))
  //           1, 2, 3, 0
  // 输出：List(6, 5, 3, 0)
}
