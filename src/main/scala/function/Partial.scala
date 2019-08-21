package function

/**
  * 偏函数：不能支持输入参数所有可能的值
  *     eg：返回输入参数的平方根
  * 全函数：支持输入参数所有可能的值
  * 部分应用函数：部分函数有可能完全调用
  */
object Partial extends App {
  val statusHandler: Int => String = {
    case 200 => "OK"
    case 400 => "Your Error"
    case 500 => "Our Error"
  }

  statusHandler(400)
//  statusHandler(401)    异常 scala.MatchError
}
