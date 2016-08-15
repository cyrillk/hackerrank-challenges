package sample

object Sample {

  private def calculate(numbers: List[Long]): Long = {
    numbers.sorted.takeRight(2).foldLeft(1l)((b, n) => b * n)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    // reads input
    val count = sc.nextLine().trim.toInt
    val numbers = sc.nextLine().split(" ", count).map(_.toLong).toList

    // calculates result
    val result = calculate(numbers)
    println(result)
  }
}
