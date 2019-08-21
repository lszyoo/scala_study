package object_trait_case

/**
  * case 类是不可实例化的类，包含多个自动生成的方法
  * ----------------------------------------------------------------------------------
  * 方法名     位置    描述
  * ----------------------------------------------------------------------------------
  * apply     对象    这是一个工厂方法，用于实例化case类
  * ----------------------------------------------------------------------------------
  * copy      类      返回实例的一个副本，并完成所需的修改。参数是类的字段，默认值设置为当前字段值。
  * ----------------------------------------------------------------------------------
  * equals    类      如果另一个实例中的所有字段与这个实例中的所有字段匹配，则返回true，可用==调用
  * ----------------------------------------------------------------------------------
  * hashCode  类      返回实例字段的一个散列码，对基于数列的集合很有用
  * ----------------------------------------------------------------------------------
  * toString  类      将类名和字段呈现为一个String
  * ----------------------------------------------------------------------------------
  * unapply   对象    将实例抽取到一个字段元组，从而可以使用case类实例完成模式匹配
  * ----------------------------------------------------------------------------------
  *
  * case class <identifier> ([var] <identifier>: <type>[,...])
  *       [extends <identifier> (<input parameters>)] [{fields, methods}]
  *
  * case 类将参数转换成值字段，所以没必要使用val
  */
object Case {
  case class Character(name: String, isThief: Boolean)

  def main(args: Array[String]): Unit = {
    val h = Character("Hadrian", true)    // 伴生对象工厂方法 Character.apply()
    println(h)    // toString()
    // 输出：Character(Hadrian,true)

    val r = h.copy(name = "Royce")    // copy()
    println(r)
    // 输出：Character(Royce,true)

    println(h == r)     // equals()
    // 输出：false

    val isThief = h match {     // unapply()
      case Character(x, true) => s"$x is a thief"
      case Character(x, false) => s"$x is ont a thief"
    }
    println(isThief)
    // 输出：Hadrian is a thief
  }
}
