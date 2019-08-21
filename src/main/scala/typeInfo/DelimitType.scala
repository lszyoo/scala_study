package typeInfo

/**
  * 定界类型：
  *     上界：限制一个类型只能是该类型或它的某个子类型，操作符 <:   父类及子类
  *     下界：限制一个类型只能是该类型或它扩展的某个基类型，操作符 >:    子类及父类
  *          下界指定了可接受的最小类
  */
object DelimitType {
  // 上界：<identifier> <: <upper bound type>
  class BaseUser(val name: String)
  class Admin(name: String, val level: String) extends BaseUser(name)
  class Customer(name: String) extends BaseUser(name)
  class PreferredCustomer(name: String) extends Customer(name)
  def check[A <: BaseUser](u: A): Unit = { if (u.name.isEmpty) println("Fail!") }


  // 下界：<identifier> >: <lower bound type>
  def recruit[A >: Customer](u: Customer): A = u match {
    case p: PreferredCustomer => new PreferredCustomer(u.name)
    case c: Customer => new Customer(u.name)
  }


  // 界定类型应用在抽象类型中
  abstract class Card {
    type UserType <: BaseUser
    def verify(u: UserType): Boolean
  }
  class SecurityCard extends Card {
    type UserType = Admin
    def verify(u: Admin) = true
  }


  def main(args: Array[String]): Unit = {
    check(new Admin("", "strict"))
    check(new Customer("Fred"))

    val customer = recruit(new Customer("Fred"))
    println(customer.name)      // 输出：Fred
    val preferred = recruit(new PreferredCustomer("George"))
    println(preferred.name)     // 输出：George

    val v1 = new SecurityCard().verify(new Admin("George", "high"))
    println(v1)
    // 输出：true
  }
}
