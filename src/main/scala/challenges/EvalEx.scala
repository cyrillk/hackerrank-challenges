package challenges

/**
  * https://www.hackerrank.com/challenges/eval-ex
  */
object EvalEx {

  private def f(x: Float): Float = {

    def fac(num: Int): Int = num match {
      case 1 => num
      case b => fac(num - 1) * num
    }

    def sum(num: Int) = num match {
      case 0 => 1.toFloat
      case 1 => x
      case a => (Math.pow(x, a) / fac(a)).toFloat
    }

    (0 until 10).map(sum).sum
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    // reads input
    val count = sc.nextLine().trim.toInt
    val numbers = (0 until count).map(_ => sc.nextFloat())

    // calculates result
    val result = numbers.map(f)
    println(result.map(n => f"$n%.4f").mkString("\n"))
  }
}
