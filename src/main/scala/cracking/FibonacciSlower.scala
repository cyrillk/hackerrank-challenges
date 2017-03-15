package cracking

object FibonacciSlower {

  def calculate(num: Int): Long = {

    def calculateAcc(next: Int): Long = {
      next match {
        case 0 => 0L
        case 1 => 1L
        case n => calculateAcc(n - 1) + calculateAcc(n - 2)
      }
    }

    calculateAcc(num)
  }
}
