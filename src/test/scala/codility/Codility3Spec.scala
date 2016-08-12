package codility

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

class Codility3Spec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(Codility3Spec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "a0Ba"
    )

    val expectedOutput = List(
      "2"
    )

    toAssert(actualInput, expectedOutput)
  }

  "Scenario #2" should "pass" in {

    val actualInput = List(
      "a0bb"
    )

    val expectedOutput = List(
      "-1"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object Codility3Spec {

  case class Store(sum: Int = 0, hasCapital: Boolean = false)

  def solution(s: String): Int = {
    val bytes = s.getBytes

    // println(bytes.mkString("~")) // azAZ09 >>> 97~122~65~90~48~57

    var result = Store()
    var actual = Store()

    bytes.foreach {
      case b if b >= 48 && b <= 57 => if (actual.hasCapital && actual.sum >= result.sum) result = actual
      case b if b >= 97 && b <= 122 => actual = Store(actual.sum + 1, actual.hasCapital)
      case b if b >= 65 && b <= 90 => actual = Store(actual.sum, true)
    }

    if (actual.hasCapital && actual.sum >= result.sum) result = actual

    return if (result.sum > 0) result.sum else -1
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val line = sc.nextLine()

    println(solution(line))
  }
}