package cracking

import scala.annotation.tailrec

object CommonDivisor {

  @tailrec
  def calculate(n: Int, m: Int): Int = {
    if (n % m == 0) m else calculate(m, n % m)
  }
}