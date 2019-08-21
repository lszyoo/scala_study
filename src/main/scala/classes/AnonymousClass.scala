package classes

/**
  * 匿名类：子类只需使用一次，有助于简化代码基
  */
object AnonymousClass {
  abstract class Listener {
    def trigger
  }

  class Listening {
    var listener: Listener = null
    def register(l: Listener) {listener = l}
    def sendNotification() {listener.trigger}
  }

  def main(args: Array[String]): Unit = {
    // 匿名类，实例化抽象类，但必须实现其方法
    val myListener = new Listener {
      override def trigger: Unit = {
        println(s"Trigger at ${new java.util.Date}")
      }
    }

    val notification = new Listening()
    notification.register(new Listener {
      override def trigger {  println(s"Trigger at ${new java.util.Date}")  }
    })
  }
}
