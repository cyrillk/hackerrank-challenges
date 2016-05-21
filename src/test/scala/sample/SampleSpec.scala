package sample

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

class SampleSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(SampleSpec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "1"
    )

    val expectedOutput = List(
      "1"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object SampleSpec {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val count = sc.nextLine().trim.toInt

    println(count)
  }
}