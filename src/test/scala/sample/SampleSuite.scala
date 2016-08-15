package sample

import org.scalatest.{FunSuite, Matchers}
import sample.matchers.SystemIOStringMatcher

class SampleSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def toAssert = assertResults(Sample.main(Array.empty[String])) _

  test("Scenario #1") {

    val actualInput =
      """
        |5
        |1 2 3 4 5
      """.stripMargin.trim


    val expectedOutput =
      """
        |20
      """.stripMargin.trim

    toAssert(actualInput, expectedOutput)
  }
}