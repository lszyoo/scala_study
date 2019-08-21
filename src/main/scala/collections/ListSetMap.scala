package collections

/**
  * Scala 的 List、Set、Map默认为不可变
  * 均是 Iterable 的子类
  *
  * 迭代
  * 映射：将一个列表逐项地转换为一个不同的列表
  * 归约：将一个列表"折叠"为单个元素
  */
object ListSetMap extends App {
  /**
    * List 是一个不可变的单链表
    */
  val numbers = List(32, 95, 43, 56)
  println(numbers)
  // 输出：List(32, 95, 43, 56)

  val color = List("red", "green", "blue")
  println(color)
  // 输出：List(red, green, blue)


  // 列表的方法
  println(s"I have ${color.size} colors: $color")
  // 输出：I have 3 colors: List(red, green, blue)
  println(color.head)
  // 输出：red
  println(color.tail)
  // 输出：List(green, blue)
  println(color(2))
  // 输出：blue


  // 列表的迭代
  var total = 0
  for (i <- numbers) {
    total += i
  }
  println(total)
  // 输出：226


  /**
    * 高阶函数
    * foreach()：对列表中的每一项分别调用这个函数
    * map()：将一个列表元素转换为另一个值或类型
    * reduce()：将两个列表元素结合为一个元素
    */
  color.foreach((c: String) => println(c))
  /*
    输出：
        red
        green
        blue
    */
  val colorsSize = color.map((c: String) => c.size)
  println(colorsSize)
  // 输出：List(3, 5, 4)

  val numSum = numbers.reduce((a: Int, b: Int) => a + b)
  println(numSum)
  // 输出：226


  /**
    * Set 是一个不可变的无序集合，只包含不重复的唯一元素
    */
  val unique = Set(10, 20, 20, 30)
  println(unique)
  // 输出：Set(10, 20, 30)
  val sum = unique.reduce((a, b) => a + b)
  println(sum)
  // 输出：60


  /**
    * Map 是一个不可变的键值库
    */
  val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
  println(colorMap)
  // 输出：Map(red -> 16711680, green -> 65280, blue -> 255)
  println(colorMap("red"))
  // 输出：16711680
  println(colorMap.contains("white"))
  // 输出：false
  for (pairs <- colorMap) {
    println(pairs)
  }
  /*
    输出：(red,16711680)
         (green,65280)
         (blue,255)
   */
}
