package collections

/**
  * 列表映射操作
  */
object ListMapOperate extends App {
  // collect  里边使用一个偏函数，保留可应用的元素
  println(List(0, 1, 0).collect{case 1 => "ok"})
  // 输出：List(ok)

  // flatMap
  println(List("milk, tea").flatMap(_.split(",")))
  // 输出：List(milk,  tea)

  // map
  println(List("milk, tea").map(_.toUpperCase))
  // 输出：List(MILK, TEA)
}
