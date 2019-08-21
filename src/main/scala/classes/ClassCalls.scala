package classes

object ClassCalls {
  /**
    * 定义一个简单的类：
    *   class <identifier> [extends <identifier>][{fields, methods, classes}]
    */
  class User1

  class User2 {
    val name: String = "Yubaba"
    def greet: String = s"Hello from $name"
    // 覆盖默认的toString方法
    override def toString = s"User2($name)"
  }

  /**
    * 定义有输入参数的类：
    *     class <identifier>([var|val] <identifier>: type[, ...])
    *         [extends <identifier>(<input parameters>)]
    *         [{fields, methods}]
    */
  class User3(n: String) {
    val name: String = n    // 变量名称 name 不能与 n 一样
    def greet: String = s"Hello from $name"
    // 覆盖默认的toString方法
    override def toString = s"User3($name)"
  }

  class User4(val name: String) {
    def greet: String = s"Hello from $name"
    override def toString = s"User4($name)"
  }

  class Car(val make: String, var reserved: Boolean) {
    def reserve(r: Boolean) = {reserved = r}
  }

  class Lotus(val color: String, reserved: Boolean) extends Car("Lotus", reserved)

  /**
    * 定义一个有输入参数和默认值的类：
    *     class <identifier>([var|val] <identifier>: type = <expression>[, ...])
    *         [extends <identifier>(<input parameters>)]
    *         [{fields, methods}]
    */
  class Car1(val make: String, var reserved: Boolean = true, val year: Int = 2019) {
    override def toString = s"$year $make, reserved = $reserved"
  }


  /**
    * 定义一个有类型参数的类：
    * class <identifier>[type-parameters]
    *      ([var|val] <identifier>: type = <expression>[, ...])
    *      [extends <identifier>(<input parameters>)]
    *      [{fields, methods}]
    */
  class Singular[A](element: A) extends Traversable[A] {
    override def foreach[B](f: A => B): Unit = f(element)
  }


  def main(args: Array[String]): Unit = {
    val u1 = new User1
    println(u1 + "---" + u1.isInstanceOf[AnyRef].toString)
    // 输出：scala_study.classes.User1@35f983a6---true

    val u2 = new User2
    println(u2.name + "---" + u2.greet + "---" + u2.toString)
    // 输出：Yubaba---Hello from Yubaba---User2(Yubaba)

    val u3 = new User3("Zeniba")
    println(u3.greet)
    // 输出：Hello from Zeniba


    val users = List(new User4("Shoto"), new User4("Art3mis"))
    println(users)
    // 输出：List(User4(Shoto), User4(Art3mis))
    val sizes = users.map(_.name.size)
    println(sizes)
    // 输出：List(5, 7)
    val sorted = users.sortBy(_.name)
    println(sorted)
    // 输出：List(User4(Art3mis), User4(Shoto))
    val third = users.find(_.name.contains("3"))
    println(third)
    // 输出：Some(User4(Art3mis))
    val greet = third.map(_.greet).getOrElse("hi") // 有值则返回，否则返回括号中默认值
    println(greet)
    // 输出：Hello from Art3mis


    val l = new Lotus("Silver", false)
    println(s"Requested a ${l.color} ${l.make}")
    // 输出：Requested a Silver Lotus


    val p = new Singular("Planes")
    p foreach println
    // 输出：Planes
    println(p.head)
    // 输出：Planes
    println(p.foreach(_.length))
    // 输出：()     因为foreach中没有参数值传入
    println(p)
    // 输出：ClassCalls(Planes)
  }
}
