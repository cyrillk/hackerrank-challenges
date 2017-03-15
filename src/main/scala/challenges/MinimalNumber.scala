package challenges

import scala.annotation.tailrec

object MinimalNumber {

  @tailrec
  private def calculate(count: Int, acc: String = "min(int, int)"): String = {
    count match {
      case n if n <= 2 => acc
      case _ => calculate(count - 1, s"min(int, $acc)")
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    // reads input
    val count = sc.nextLine().trim.toInt

    // calculates result
    val result = calculate(count)

    println(result)
  }
}
