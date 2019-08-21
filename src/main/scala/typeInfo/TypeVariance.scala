package typeInfo

/**
  * 类型变化
  */
object TypeVariance {
  class Car { override def toString = "Car()" }
  class Volvo extends Car { override def toString: String = "Volvo()" }
  class VolvoWagon extends Volvo

  /**
    * case class Item[A](a: A) { def get: A = a }
    * val c1: Item[Car] = new Item[Volvo](new Volvo)   报错
    *
    * 类型参数默认是不变的，不能替换为兼容的类型，解决方案：协变（covariant）类型参数，可以自动在必要时
    * 调整为其基类型，操作符：在类型参数前加一个 +
    *
    * 方法参数不支持协变，用逆变(contravariance)：
    * 是指一个类型参数可以调整为一个子类型，与子类型到基类型的多态转换方向相反，操作符：在类型参数前加一个 -
    * 可用于方法的输入参数，但不能作为返回类型，返回类型是协变的
    */
  class Item[+A](a: A) { def get: A = a }
  class Check[-A] { def check(a: A) = {} }
  // 以下两个符合多态准则
  def item(v: Item[Volvo]) { val c: Car = v.get }
  def check(v: Check[Volvo]) { v.check(new VolvoWagon) }


  def main(args: Array[String]): Unit = {
    // 多态
    val c: Car = new Volvo()

    // 协变、逆变
    val c1: Item[Car] = new Item[Volvo](new Volvo)
    // item(new Item[Car](new Car)) 异常
    item(new Item[VolvoWagon](new VolvoWagon))
    check(new Check[Car])
    check(new Check[Volvo])
    // check(new Check[VolvoWagon]) 异常

  }
}
