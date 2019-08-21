package classes

object AbstractClass {
  abstract class Car {
    val year: Int
    val automatic: Boolean = true
    def color: String
  }

  class ReMini(val year: Int) extends Car {
    override def color: String = "Red"
  }

  // 类比无参方法：color
  class Mini(val year: Int, val color: String) extends Car

  def main(args: Array[String]): Unit = {
    val m: Car = new ReMini(2019)
    println(m)
    // 输出：scala_study.classes.AbstractClass$ReMini@5e025e70

    val mini: Car = new Mini(2019, "Red")
    println(s"Got a ${mini.color} Mini")
    // 输出：Got a Red Mini
  }
}
