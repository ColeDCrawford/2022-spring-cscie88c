package org.cscie88c.week3

object UtilFunctions {

  def mult2(x: Int, y: Int): Int = x * y

  def pythTest(
      x: Int,
      y: Int,
      z: Int
    ): Boolean =
    return scala.math.pow(x, 2) + scala.math.pow(y, 2) == scala.math.pow(z, 2)

  val nums = (1 to 100).toList
  val pythTriplesUpto100: List[(Int, Int, Int)] = for {
    x <- nums
    y <- nums if y > x
    z <- nums
    if pythTest(x, y, z)
  } yield (x, y, z)

}
