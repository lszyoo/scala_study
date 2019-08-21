package implicit_conversion

/**
  * 隐式视图 -- 方法
  */
object ImplicitView {
  /**
    * 隐式转换为目标类型：把一种类型自动转换到另一种类型
    * 命名规范：sourceToTarget
    */
  // 将整数转换成字符串类型
  def foo(msg: String) = println(msg)    // 直接调用报错，error: type mismatch
  implicit def intToString(x: Int) = x.toString


  /**
    * 隐式转换调用类中本不存在的方法
    * 格式：implicit def sourceToTarget(<argument>: sourceType) = targetType
    */
  class SwingType { def wantLearning(sw: String) = println("兔子已经学会了" + sw) }
  class AnimalType
  object Swimming { implicit def learningType(s: AnimalType) = new SwingType }

  // 将隐式转换函数定义在伴生对象中，在使用时导入隐式视图到作用域中即可
  object AnimalType {
    import Swimming._
    val rabbit = new AnimalType
    rabbit.wantLearning("蛙泳")
  }

  def main(args: Array[String]): Unit = {
    // 隐式转换为目标类型
    foo(10)
    // 输出：10

    /**
      * 编译器在rabbit对象调用时发现对象上并没有wantLearned方法，此时编译器就会在作用域范围内查找能使其编译
      * 通过的隐式视图，找到learningType方法后，编译器通过隐式转换将对象转换成具有这个方法的对象，
      * 之后调用wantLearned方法
      */
    import Swimming._
    val rabbit = new AnimalType
    rabbit.wantLearning("蛙泳")
    // 输出：兔子已经学会了蛙泳

    AnimalType
    // 输出：兔子已经学会了蛙泳

  }
}
