package classes

/**
  * 在Scala中，一个类可以使用extends关键字扩展最多一个类
  */
object InheritPolymorphism {
  class A {
    def hi = "Hello from A"
    override def toString = getClass.getName
  }

  class B extends A

  class C extends B {
    override def hi = "hi C ->" + super.hi
  }

  def main(args: Array[String]): Unit = {
    /**
      * 继承
      */
    val hiA = new A().hi
    println(hiA)
    // 输出：Hello from A
    val hiB = new B().hi
    println(hiB)
    // 输出：Hello from A
    val hiC = new C().hi
    println(hiC)
    // 输出：hi C ->Hello from A


    /**
      * 多态
      */
    val a: A = new B
//    val b: B = new A   报错


    val misc = List(new C, new A, new B)
    val messages = misc.map(_.hi).distinct.sorted
    println(messages)
    // 输出：List(Hello from A, hi C ->Hello from A)
  }
}
