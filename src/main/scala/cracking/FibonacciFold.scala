package cracking

object FibonacciFold {

  def calculate(num: Int): Long = {

    (1 until num).foldLeft((0, 1)) { case ((previous, actual), _) =>
      (actual, previous + actual)
    }._2
  }
}
