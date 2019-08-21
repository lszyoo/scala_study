package variable_expression

/**
  * Write by Brain on 2019/05/30.
  */
object MatchExpression extends App {
  /**
    *  <expression> match {
    *   case <pattern match> => <expression>
    *   [case...]
    *  }
    */
  val x = 10
  val y = 20
  val max = x > y match {
    case true => x
    case false => y
  }
  println(max)
  // 输出：20

  // 返回最后一个表达式
  val status = 500
  val message = status match {
    case 200 => "ok"
    case 400 => {
      println("ERROR - we called the service incorrectly!")
      "error"
    }
    case 500 => {
      println("ERROR - the service encountered an error")
      "error"
    }
  }
  println(message)
  // 输出：ERROR - the service encountered an error
  //      error


  /**
    * 模式替换式：
    *   case <pattern1> | <pattern2> ... => <one or more expression>
    */
  val day = "Mon"
  val kind = day match {
    case "Mon" | "The" | "Wen" | "Thu" | "Fri" => "weekday"
    case "Sat" | "Sun" => "weekend"
  }
  println(kind)
  // 输出：weekday


  /**
    * 用通配模式匹配：
    *   值绑定模式：
    *     case <identifier> => <one or more expression>
    *   通配符模式：
    *     _ 相当于匿名占位符
    *     case _ => <one or more expression>
    */
  val message1 = "error"
  val status1 = message1 match {
    case "ok" => 200
    case other => {
      println(s"Couldn't parse $other")
      -1
    }
  }
  println(status1)
  //输出：Couldn't parse error
  //     -1

  val message2 = "Unauthorized"
  val status2 = message2 match {
    case "ok" => 200
    case _ => {
      println(s"Couldn't parse $message2")
      -1
    }
  }
  println(status2)
  //输出：Couldn't parse Unauthorized
  //     -1


  /**
    * 用模式哨位匹配：
    *   case <pattern> if <Boolean expression> => <one or more expression>
    *   if表达式可以不加小括号，true才返回
    */
  val response: String = null
  val isNull = response match {
    case s if s != null => println(s"response '$s'");s
//    case s if s != null => println(s"response '$s'")
//    返回 ()
    case s => println("ERROR! Received a null response!");s
  }
  println(isNull)
  // 输出：ERROR! Received a null response!
  //      null


  /**
    * 用模式变量匹配类型：
    *   case <identifier>: <type> => <one or more expression>
    * 多态
    */
  val m: Int = 12180
  val n: Any = m
  val p = n match {
    case m: String => s"'$m'"
    case m: Double => f"$m%.2f"
    case m: Float => f"$m%.2f"
    case m: Long => s"${m}l"
    case m: Int => s"${m}i"
  }
  println(p)
  // 输出：12180i
}
