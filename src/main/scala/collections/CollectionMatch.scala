package collections

object CollectionMatch extends App {
  val status = List(500, 404)

  // 通过匹配表达式来匹配单个值模式
  val msg = status.head match {
    case x if x < 500 => "okay"
    case _ => "whoah, an error"
  }
  println(msg)
  // 输出：whoah, an error


  // 利用模式哨卫，匹配一个集合中的单个值
  val msg1 = status match {
    case x if x.contains(500) => "has error"
    case _ => "okay"
  }
  println(msg1)
  // 输出：has error


  // 集合支持 == 号，匹配整个集合
  val msg2 = status match {
    case List(404, 500) => "not found & error"
    case List(500, 404) => "error & not found"
    case List(200, 200) => "okay"
    case _ => "not sure what happened"
  }
  println(msg2)
  // 输出：error & not found


  // 值绑定：在模式哨卫中将值绑定到集合中的一些或所有元素
  val msg3 = status match {
    case List(500, x) => s"Error followed by $x"
    case List(e, x) => s"$e was followed by $x"
  }
  println(msg3)
  // 输出：Error followed by 404


  // 列表分解为表头元素和表尾，匹配表头和表尾
  val head = List('r', 'g', 'q') match {
    case x :: xs => x
    case Nil => ' '
  }
  println(head)
  // 输出：r
}
