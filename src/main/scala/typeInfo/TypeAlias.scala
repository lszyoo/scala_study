package typeInfo

/**
  * 类型别名：
  *     type <identifier>[type parameters] = <type name>[type parameters]
  * 类型别名可以解析一个类
  */
object TypeAlias {
  type Whole = Int
  type UserInfo = Tuple2[Int, String]
  type T3[A, B, C] = Tuple3[A, B, C]

  def main(args: Array[String]): Unit = {
    val x: Whole = 5
    println(x)
    // 输出：5

    val u: UserInfo = new UserInfo(1, "George")
    println(u)
    // 输出：(1,George)

    val things = new T3(1, 's', true)
    println(things)
    // 输出：(1,s,true)
  }
}
