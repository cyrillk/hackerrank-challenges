package cracking

import scala.math.BigInt

object FactorialRecursive {

  def calculate(num: Int): BigInt = {

    def calculateRec(x: BigInt): BigInt = {
      if (x == 1) 1 else x * calculateRec(x - 1)
    }

    calculateRec(BigInt(num))
  }
}
