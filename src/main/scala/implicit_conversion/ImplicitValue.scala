package implicit_conversion

/**
  * 隐式值 -- 参数
  *
  * 隐式转换必须满足无歧义规则，在声明隐式参数的类型是最好使用特别的或自定义的数据类型，
  * 不要使用Int,String这些常用类型，避免碰巧匹配
  */
object ImplicitValue {
  // name为隐式参数
  // implicit 放在参数列表的最前面，不管有几个参数，它们全部都是隐式的
  def person(implicit name: String) = name      // 直接调用报错，error: could not find implicit value for parameter name: String
  // p被称为隐式值
  implicit val p = "Alien"
  // implicit val p1 = "Alien1"    再次调用报错，error: ambiguous implicit values


  def main(args: Array[String]): Unit = {
    println(person)
    // 输出：Alien
  }
}
