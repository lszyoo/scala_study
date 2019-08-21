package function

/**
  * 嵌套函数
  *
  * Scala 按 函数名及参数列表 区分函数
  */
object Nested extends App {
  // 函数同名同参也可，因为内外之分
  def max(a: Int, b: Int, c: Int) = {
    def max(x: Int, y: Int) = if (x > y) x else y
    max(a, max(b, c))
  }
  println(max(42, 181, 19))
  // 输出：181
}
