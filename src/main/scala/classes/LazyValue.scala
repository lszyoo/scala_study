package classes

/**
  * 类中的值和变量都是在类第一次实例化时创建的。但是，
  * 懒值是在第一次实例化这些值时才创建，懒值是一个缓存的函数结果
  */
object LazyValue {
  class RandomPoint {
    val x = {
      println("creating x")
      util.Random.nextInt
    }
    lazy val y = {  println("now y"); util.Random.nextInt }
  }

  def main(args: Array[String]): Unit = {
    /**
      * "x" 字段是一个常规值，它在创建实例 "p" 时初始化。
      * "y" 是一个懒值，在我们第一次访问它时才初始化，不过只是第一次。
      * 在第二个输出结果中，两个值都已经初始化，而且是稳定的。若再访问，则在内存中直接取值。
      */
    val p = new RandomPoint()
    println(s"Location is ${p.x}, ${p.y}")
    /*
      输出：creating x
           now y
           Location is -1704434838, 1995303373（可以看到x、y的值时不同的，说明不是一起初始化的）
     */
    println(s"Location is ${p.x}, ${p.y}")
    // 输出：Location is -1704434838, 1995303373
  }
}
