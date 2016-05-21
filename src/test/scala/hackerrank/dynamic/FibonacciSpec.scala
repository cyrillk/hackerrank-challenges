package hackerrank.dynamic

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

class FibonacciSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(FibonacciSpec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "20"
    )

    val expectedOutput = List(
      "6765"
    )

    toAssert(actualInput, expectedOutput)
  }

  "Scenario #2" should "pass" in {

    val actualInput = List(
      "40"
    )

    val expectedOutput = List(
      "102334155"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object FibonacciSpec {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val number = sc.nextLine().trim.toInt

    val result = (0 to number).foldLeft(Map.empty[Int, Long]) {
      case (m, 0) => m + (0 -> 0)
      case (m, 1) => m + (1 -> 1)
      case (m, n) => m + (n -> (m(n - 1) + m(n - 2)))
    }

    println(result(number))
  }
}