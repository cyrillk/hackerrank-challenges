package cracking

import scala.annotation.tailrec

object FibonacciFaster {

  def calculate(num: Int): Long = {

    @tailrec
    def calculateAcc(counter: Int, previous: Long = 0, actual: Long = 1): Long = {
      counter match {
        case n if n <= 1 => actual
        case _ => calculateAcc(counter - 1, actual, previous + actual)
      }
    }

    calculateAcc(num, 0, 1)
  }
}
