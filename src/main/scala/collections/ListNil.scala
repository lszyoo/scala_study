package collections

/**
  * 所有列表都有一个 Nil 实例作为终结点，所以迭代器可以通过比较当前元素和 Nil 来检查是否到达列表末尾
  */
object ListNil extends App {
  val primes = List(2, 3, 5, 7, 11)
  println(primes)
  // 输出：List(2, 3, 5, 7, 11)


  // 遍历
  var i = primes
  while (! i.isEmpty) {
    print(i.head + ",")
    i = i.tail
  }
  // 输出：2,3,5,7,11,
  println()

  var j = primes
  while (j != Nil) {
    print(j.head + ",")
    j = j.tail
  }
  println(Nil == List())
  // 输出：2,3,5,7,11,true


  // 递归方式遍历
  def visit(i: List[Int]): Unit = {
    if (i.size > 0) {
      print(i.head + ",")
      visit(i.tail)
    }
  }
  visit(primes)
  // 输出：2,3,5,7,11,
  println()


  /**
    * Cons 操作符：构建列表
    */
  val numbers = 1 :: 2 :: 3 :: Nil
  println(numbers)
  // 输出：List(1, 2, 3)

  val first = Nil.::(1)
  println(first)
  // 输出：List(1)

  val second = 2 :: first
  println(second)
  // 输出：List(2, 1)
}
