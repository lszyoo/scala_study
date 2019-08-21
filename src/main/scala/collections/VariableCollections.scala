package collections

/**
  *      不可变类型(自动加载)                     可变类型
  * collection.immutable.List         collection.mutable.Buffer
  * collection.immutable.Set          collection.mutable.Set
  * collection.immutable.Map          collection.mutable.Map
  */
object VariableCollections extends App {
  /**
    * 不可变类型
    */
  val m = Map("AAPL" -> 597, "MSFT" -> 40)
  val n = m - "AAPL" + ("GOOG" -> 521)    // 对 m 操作，但 m 不变
  println(m)    // 输出：Map(AAPL -> 597, MSFT -> 40)
  println(n)    // 输出：Map(MSFT -> 40, GOOG -> 521)


  /**
    * 可变类型
    */
  // 方式一：直接创建
  val nums = collection.mutable.Buffer(1)
  println(nums)
  // 输出：ArrayBuffer(1)
  for (i <- 2 to 10) nums += i
  println(nums)
  // 输出：ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  // 空集合，必须用类型参数指定集合的类型
  val nums1 = collection.mutable.Buffer[Int]()
  println(nums1)
  // 输出：ArrayBuffer()
  for (i <- 1 to 10) nums1 += i
  println(nums1)
  // 输出：ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


  // 可变的缓存转换成不可变的列表
  println(nums.toList)
  // 输出：List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


  // 方式二：用不可变到可变
  val b = m.toBuffer
  b += ("GOOG" -> 521)
  println(b)
  // 输出：ArrayBuffer((AAPL,597), (MSFT,40), (GOOG,521))
  println(b.toMap)    // 可变到不可变
  // 输出：Map(AAPL -> 597, MSFT -> 40, GOOG -> 521)
  println(b.toSet)
  // 输出：Set((AAPL,597), (MSFT,40), (GOOG,521))
  println(b.toList)
  // 输出：List((AAPL,597), (MSFT,40), (GOOG,521))


  // 方式三：集合构造器 （应用场景：若只迭代构造一个可变集合，并把它转换成不可变集合）
  // Builder 是 Buffer的一个简化形式，仅限生成指定集合类型，并只支持追加操作
  val s = Set.newBuilder[Char]
  println(s.result())
  // 输出：Set()
  s += 'h'
  println(s.result())
  // 输出：Set(h)
  s ++= List('e', 'l', 'l', 'o')
  println(s.result())
  // 输出：Set(h, e, l, o)
}
