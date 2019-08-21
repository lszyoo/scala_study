package object_trait_case

/**
  * trait 是一种支持多重继承的类，但不能实例化。
  * trait 不能有类参数，但是可以有类型参数
  *
  * trait <identifier> [extends <identifier>] [{fields, methods, classes}]
  *
  * trait 在父类后面
  *
  * 线性化：尽管支持多重继承，但编译器实际上会创建各个trait的副本，形成类与trait组成的单列层次体系，如：一个类
  *       扩展了类A以及trait B和C，编译到.class二进制文件时，实际上他会扩展一个类，这个类又扩展另外一个类，
  *       后者进一步扩展了下一个类
  *
  * 多重继承顺序：从右向左，即从最低的子类到最高基类，例如：
  *       class D extends A with B with C <=> class D extends C extends B extends A
  *
  * 自类型：是trait的一个注解，向一个类增加这个trait时，要求这个类必须有一个特定的类型或子类型。
  *       有自类型注解的trait不能增加到未扩展指定类型的类。
  *       用法：为需要输入参数的类增加功能。
  *       trait ... {<identifier>: <type> => ...}
  *
  * 用 trait 实例化：用trait扩展类
  */
object Trait {
  trait HtmlUtils {
    def removeMarkup(input: String) = {
      input
        .replaceAll("""</?\w[^>]*>""", "")
        .replaceAll("<.*>", "")
    }
  }

  class Page(val s: String) extends HtmlUtils {
    def asPlainText = removeMarkup(s)     // 直接使用 removeMarkup() 函数，不用指定对象名
  }

  trait SafeStringUtils {
    def trimToNone(s: String): Option[String] = {
      Option(s).map(_.trim).filterNot(_.isEmpty)
    }
  }

  class Page1(val s: String) extends SafeStringUtils with HtmlUtils {
    def asPlainText: String = {
//      trimToNone(s) map removeMarkup getOrElse "n/a"
      trimToNone(s).map(removeMarkup).getOrElse("n/a")
    }
  }


  /**
    * 验证继承顺序
    */
  trait Base {
    override def toString = "Base"
  }
  class A extends Base {
    override def toString = "A -> " + super.toString
  }
  trait B extends Base {
    override def toString = "B -> " + super.toString
  }
  trait C extends Base {
    override def toString = "C -> " + super.toString
  }
  class D extends A with B with C {
    override def toString = "D -> " + super.toString
  }


  /**
    * 编写trait来覆盖g共享父类的行为
    */
  class RGBColor(val color: Int) {
    def hex = f"$color%06X"
  }
  trait Opaque extends RGBColor {
    override def hex = s"${super.hex}FF"
  }
  trait Sheer extends RGBColor {
    override def hex: String = s"${super.hex}33"
  }
  // 扩展父类功能：可以向 RGBColor 传递类参数
  class Paint(color: Int) extends RGBColor(color) with Opaque
  class Overlay(color: Int) extends RGBColor(color) with Sheer


  /**
    * self type：自类型
    */
  // 这里使用一个自类型来确保它总是指定类型的一个子类型，说明：自类型对trait增加有所限制
  class E { def hi = "hi" }
  trait F {         // trait F 有一个自类型，这要求这个trait只能增加到指定类型（类E）的一个子类
    self: E =>
      override def toString = "F: " + hi
  }
//  class G extends F     没有扩展所指定的类
  class G extends E with F

  // 自类型扩展类的功能
  class TestSuite(suiteName: String) { def start() {} }
  // 通过自类型，可隐性认为 RandomSeeded 是 TestSuite的一个子类型
  trait RandomSeeded {
    self: TestSuite =>
      def randomStart() = {
        util.Random.setSeed(System.currentTimeMillis())
        self.start()
      }
  }
  class IdSpec extends TestSuite("ID Tests") with RandomSeeded {
    def testId(): Unit = {
      println(util.Random.nextInt() != 1)
    }
    override def start(): Unit = {
      testId()
    }
    println("Starting ...")
    randomStart()
  }


  /**
    * 用trait实例化
    */
  class User(val name: String) {
    def suffix = ""
    override def toString = s"$name$suffix"
  }
  trait Attorney {
    self: User => override def suffix: String = ", esq."
  }
  trait Wizard {
    self: User => override def suffix: String = ", Wizard"
  }
  trait Reverser {
    override def toString: String = super.toString.reverse
  }


  def main(args: Array[String]): Unit = {
    println(new Page("<html><body><h1>Introduction</h1></body></html>").asPlainText)
    // 输出：Introduction

    println(new Page1("<html><body><h1>Introduction</h1></body></html>").asPlainText)
    // 输出：Introduction
    println(new Page1("   ").asPlainText)
    // 输出：n/a

    println(new D)
    // 输出：D -> C -> B -> A -> Base

    val green = new RGBColor(255 << 8).hex
    println(green)
    // 输出：00FF00
    val red = new Paint(128 << 16).hex
    println(red)
    // 输出：800000FF
    val blue = new Overlay(192).hex
    println(blue)
    // 输出：0000C033

    println(new G())
    // 输出：F: hi

    println(new User("Harry P") with Attorney)
    // 输出：Harry P, esq.
    println(new User("Ginny W") with Wizard)
    // 输出：Ginny W, Wizard
    println(new User("Luna L") with Wizard with Reverser)
    // 输出：draziW ,L anuL
  }
}
