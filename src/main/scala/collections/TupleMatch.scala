package collections

object TupleMatch extends App {
  val code = ('h', 204, true) match {
    case (_, _, false) => 501
    case ('c', _, true) => 302
    case ('h', x, true) => x
    case (c, x, true) => {
      println(s"Did not expect code $c")
      x
    }
  }
  println(code)
  // 输出：204
}
