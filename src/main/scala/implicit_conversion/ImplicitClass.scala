package implicit_conversion

/**
  * 隐式类
  *   1.其所带的构造参数有且只能有一个
  *   2.隐式类必须被定义在类，伴生对象和包对象里
  *   3.隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
  *   4.作用域内不能有与之相同名称的标示符
  */
object ImplicitClass {
  object StringUtils {
    implicit class StringImprovement(val s: String) {
      def increment = s.map(x => (x + 1).toChar)
    }
  }


  object ImplicitClasses {
    implicit class Hello(s: String) { def hello = s"Hello, $s" }
    def test = { println("World".hello) }
  }

  def main(args: Array[String]): Unit = {
    import StringUtils._
    println("Alien".increment)
    // 输出：Bmjfo

    println(('A' + 1).toChar)
    // 输出：B

    ImplicitClasses.test
    // 输出：Hello, World
  }
}
