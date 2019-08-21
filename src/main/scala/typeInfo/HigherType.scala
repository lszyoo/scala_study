package typeInfo

object HigherType {
  def main(args: Array[String]): Unit = {
    // 以下两个表达式等价
    val t1: (Int, Char) = (1, 'a')
    // t1: (Int, Char) = (1, 'a')
    val t2: (Int, Char) = Tuple2[Int, Char](1, 'a')
    // t2: (Int, Char) = (1, 'a')

    // 以下两个表达式等价
    val f1: Int => Int = _ + 2
    // f1: Int => Int = <function1>
    val f2: Int => Int = new Function1[Int, Int] { def apply(x: Int) = x + 2 }
    // f2: Int => Int = <function1>
  }
}
