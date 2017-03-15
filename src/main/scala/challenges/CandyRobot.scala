package challenges

object CandyRobot {

  private def calculate(size: Int, numbers: List[Int]): Int = {

    var result = 0
    var amount = size

    for (n <- numbers.indices) {
      amount = amount - numbers(n)

      if (amount < 5 && n < numbers.size - 1) {
        result = result + (size - amount)
        amount = size
      }
    }

    result
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    // reads input
    val n :: t :: Nil = sc.nextLine().split(" ").map(_.toInt).toList
    val numbers = sc.nextLine().split(" ", t).map(_.toInt).toList

    // calculates result
    val result = calculate(n, numbers)
    println(result)
  }
}
