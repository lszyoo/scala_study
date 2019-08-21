package typeInfo

/**
  * 抽象类型是规范，可以解析多个类
  *
  * 抽象类型是抽象的，不能实例化
  *
  * 常用于类型参数和抽象类中的类型声明
  */
object AbstractType {
  /**
    * trait 可以包含一个未指定类型的类型别名
    */
  class User(val name: String)
  trait Factory { type A; def create: A}
  trait UserFactory extends Factory {
    type A = User
    def create = new User("")
  }

  // 效果同上
  trait Factory1[A] {def create: A}
  trait UserFactory1 extends Factory1[User] {
    def create = new User("")
  }

}
