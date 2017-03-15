package challenges

object MelodiousPassword {

  private val vows = Set("a", "e", "i", "o", "u")
  private val cons = Set("b", "c", "d", "f", "g", "h", "j", "k",
    "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z")

  private def left(seq: Set[String]): Set[String] = {
    seq.flatMap {
      case s if vows.contains(s.take(1)) => cons.map(_ + s)
      case s => vows.map(_ + s)
    }
  }

  private def right(seq: Set[String]): Set[String] = {
    seq.flatMap {
      case s if vows.contains(s.takeRight(1)) => cons.map(s + _)
      case s => vows.map(s + _)
    }
  }

  @scala.annotation.tailrec
  private def calculate(count: Int, acc: Set[String] = vows ++ cons): Set[String] = {
    count match {
      case n if n <= 1 => acc
      case _ => calculate(count - 1, left(acc) ++ right(acc))
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    // reads input
    val count = sc.nextLine().trim.toInt

    // calculates result
    val result = calculate(count)

    println(result.mkString("\n"))
  }
}
