package classes

/**
  * 重载，一般都是设置默认参数值来避免重载
  */
object Overload {
  class Printer(msg: String) {
    def print(s: String) = println(s"$msg: $s")
    def print(l: Seq[String]) = println(l.mkString(","))
  }


  /**
    * apply() 方法实际上是一个快捷方式，可以使用小括号触发功能而不需要方法名。
    * 相当于类的默认方法
    */
  class Multiplier(factor: Int) {
    def apply(input: Int) = input * factor
  }

  def main(args: Array[String]): Unit = {
    new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil)
    // 输出：Foggy,Rainy,Hot


    val tripleMe = new Multiplier(3)
    println(tripleMe.apply(10))
    // 输出：30
    println(tripleMe(10))
    // 输出：30

    // List类用了 apply() 方法
    val l = List('a', 'b', 'c')
    val character = l(1)
    println(character)
    // 输出：b
  }
}
