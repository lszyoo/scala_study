package collections.monadic

import concurrent.ExecutionContext.Implicits.global

/**
  * Future  对应最终的值
  * concurrent.Future：是后台java线程的一个监视器
  */
object MonadicFuture extends App {
  // 打印了 hi 之后才会返回 Future
//  val f = concurrent.Future { println("hi") }

  val f1 = concurrent.Future { Thread.sleep(50);println("hi") }
  println("waiting")
}
