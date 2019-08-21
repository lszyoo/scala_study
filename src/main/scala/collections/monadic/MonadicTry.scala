package collections.monadic

/**
  * Try 对应成功的值
  * 将错误处理转换为集合管理
  *
  * Scala 支持 try{}...catch{}块，但没有上边的安全
  */
object MonadicTry {
  def loopAndFail(end: Int, failAt: Int): Int = {
    for (i <- 1 to end) {
      println(s"$i")
      if (i == failAt) throw new Exception("Too many iterations")
    }
    end
  }

  def nextErrot = util.Try(1 / util.Random.nextInt(2))

  def main(args: Array[String]): Unit = {
//    loopAndFail(10, 3)
    /*
      1
      2
      3
      Exception in thread "main" java.lang.Exception: Too many iterations
        at scala_study.collections.monadic.MonadicTry$$anonfun$loopAndFail$1.apply$mcVI$sp(MonadicTry.scala:11)
        at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:160)
        at scala_study.collections.monadic.MonadicTry$.loopAndFail(MonadicTry.scala:9)
        at scala_study.collections.monadic.MonadicTry$.main(MonadicTry.scala:17)
        at scala_study.collections.monadic.MonadicTry.main(MonadicTry.scala)
     */

    println(util.Try(loopAndFail(2, 3)))
    /*
      输出：1
           2
           Success(2)
      */

    println(util.Try(loopAndFail(4, 2)))
    /*
      输出：1
           2
           Failure(java.lang.Exception: Too many iterations)
      */

    // 直接抛异常，最常用
    val x = nextErrot
    val y = nextErrot
    println(x)
    println(y)
    // 成功：Success(1)；失败：Failure(java.lang.ArithmeticException: / by zero)

    println(x.flatMap(_ => y))
    /*
        x败y成：Failure(java.lang.ArithmeticException: / by zero)
        x败y败：Failure(java.lang.ArithmeticException: / by zero)
        x成y败：Failure(java.lang.ArithmeticException: / by zero)
        x成y成：Success(1)
      */
    println(x.foreach(x => println("success!" + x)))
    // x败：()，x成：success!1   ()
    println(x.getOrElse(0))
    // x败：0，x成：1
    println(x.orElse(y))
    // x败y成：Success(1)，x成y败：Success(1)，x败y败：Failure(java.lang.ArithmeticException: / by zero)，x成y成：Success(1)
    println(x.toOption)
    // x败：None，x成：Some(1)
    println(x.map(_ * 2))
    // x败：Failure(java.lang.ArithmeticException: / by zero)，x成：Success(2)
    println(x match {
      case util.Success(x) => x
      case util.Failure(error) => -1
    })
    // x败：-1，x成：1


    val input = " 123 "
    val result = util.Try(input.toInt).orElse(util.Try(input.trim.toInt))
    println(result)
    // 输出：Success(123)
    result.foreach{ r => println(s"Parsed '$input' to $r!")}
    // 输出：Parsed ' 123 ' to 123!
    val xr = result match {
      case util.Success(x) => Some(x)
      case util.Failure(ex) => {
        println(s"Couldn't parse input $input")
        None
      }
    }
    println(xr)
    // 输出：Some(123)
  }
}
