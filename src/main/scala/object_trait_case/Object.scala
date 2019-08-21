package object_trait_case

/**
  * 对象（object）是一个类类型，只能有不超过一个实例，称为一个单例。
  * 对象不许用 new 来创建实例，只需按名直接访问对象，对象会在首次访问时在当前运行的JVM中自动实例化
  *
  * 类比：Java 静态类和方法
  *
  * 对象和类没有完全解耦
  *
  * object <identifier> [extends <identifier>] [{fields, methods, classes}]
  *
  * 适合对象的方法是：纯函数（返回完全由其输入计算得到的结果）
  *                I/O函数（处理文件、数据库和外部服务）
  */
object Object {
  object Hello {
    println("in Hello")
    def hi = "hi"
    def hello = "hello"
  }


  // 纯函数
  object HtmlUtils {
    def removeMarkup(input: String) = {
      input
        .replaceAll("""</?\w[^>]*>""", "")
        .replaceAll("<.*>", "")
    }
  }


  /**
    * 工厂模式：是对象 apply() 方法的一种流行用法，可从伴生对象生成一个类的新实例。
    * 伴生对象：是与类同名的一个对象，与类在同一个文件中定义。
    */
  class Multiplier(val x: Int) {
    def product(y: Int) = x * y
  }

  object Multiplier {
    private val name = ""
    def apply(x: Int) = new Multiplier(x)
  }

  // 类和伴生对象共享访问控制
  object DBConnection {
    private val db_url = "jdbc://localhost"
    private val db_user = "franken"
    private val db_pass = "berry"

    def apply() = new DBConnection
  }
  // 不能访问 Multiplier 对象的私有属性 name
  class DBConnection {
    private val props = Map(
      "url" -> DBConnection.db_url,
      "user" -> DBConnection.db_user,
      "pass" -> DBConnection.db_pass
    )
    println(s"Created new connection for" + props("url"))
  }


  def main(args: Array[String]): Unit = {
    println(Hello.hi)
    /*
        输出：in Hello
             hi
      */
    println(Hello.hello)
    // 输出：hello     对象只能实例化一次，现在已经在内存中实例化


    val html = "<html><body><h1>Introduction</h1></body></html>"
    val text = HtmlUtils.removeMarkup(html)
    println(text)
    // 输出：Introduction


    val tripler = Multiplier(3)
    val result = tripler.product(13)
    println(result)
    // 输出：39


    val conn = DBConnection()

  }
}
