package collections

/**
  * 列表算数运算
  */
object ListOperate extends App {
  val list1 = List(1, 2, 3, 4)
  val list2 = List("ae", "b", "cwg", "down")

  // ::  为列表追加单个元素，这是一个右结合操作符
  println(5 :: list1)
  // 输出：List(5, 1, 2, 3, 4)
  println(list1 :: 6 :: Nil)
  // 输出：List(List(1, 2, 3, 4), 6)

  // :+  为列表追加单个元素，这是一个左结合操作符
  println(list1 :+ 5)
  // 输出：List(1, 2, 3, 4, 5)
  println(5 +: list1)
  // 输出：List(5, 1, 2, 3, 4)

  // :::  在列表前边追加另一个列表，这是一个右结合操作符
  println(list1 ::: list2)
  // 输出：List(1, 2, 3, 4, ae, b, cwg, down)

  // ++  为列表追加另一个集合
  println(list1 ++ Set(8, 7, 7))
  // 输出：List(1, 2, 3, 4, 8, 7)

  // ==  若列表类型和内容都相同，则返回 true
  println(list1 == list2)
  // 输出：false

  // distinct  去重列表重复元素，返回新列表
  println(List(1, 2, 3, 3).distinct)
  // 输出：List(1, 2, 3)

  // drop  删除前n个元素
  println(list1.drop(2))
  // 输出：List(3, 4)
  println(list1.dropRight(2))
  // 输出：List(1, 2)

  // dropWhile  从第一个元素开始，删除满足条件的元素，直到不满足为止
  println(List(1, 2, 3, 2).dropWhile(_ <= 2))
  // 输出：List(3, 2)

  // filter  返回经过true筛选的元素组成的列表
  println(list1.filter(_ > 3))
  // 输出：List(4)

  // flatten  将一个元素是列表的列表合成一个元素列表
  println(List(list1, list2).flatten)
  // 输出：List(1, 2, 3, 4, ae, b, cwg, down)

  // partition  将一个列表拆分成由两个列表组成的元组
  println(list1.partition(_ < 3))
  // 输出：(List(1, 2),List(3, 4))

  // reverse   逆置列表
  println(list1.reverse)
  // 输出：List(4, 3, 2, 1)

  // slice  返回列表的一部分，从第一个索引到第二个索引，但不包含第二个索引
  println(list2.slice(0, 3))
  // 输出：List(ae, b, cwg)

  // sortBy  根据函数返回值排序
  println(list2.sortBy(_.size))
  // 输出：List(b, ae, cwg, down)

  // sorted  按自然值排序
  println(List("d", "ae", "cd").sorted)
  // 输出：List(ae, cd, d)

  // splitAt  根据给定索引将列表分成两个
  println(list2.splitAt(2))
  // 输出：(List(ae, b),List(cwg, down))

  // take  取出前n个元素
  println(list2.take(2))
  // 输出：List(ae, b)
  println(list2.takeRight(2))
  // 输出：List(cwg, down)

  // takeWhile  从第一个元素开始，取满足条件的元素，直到不满足为止
  println(list2.takeWhile(_.length >= 2))
  // 输出：List(ae)

  // 合并两个列表为元组列表
  println(list2.zip(list1))
  // 输出：List((ae,1), (b,2), (cwg,3), (down,4))
}
