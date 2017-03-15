package challenges

import matchers.SystemIOStringMatcher
import org.scalatest.{FunSuite, Matchers}

class MinimalNumberSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def toAssert = assertResults(MinimalNumber.main(Array.empty[String])) _

  test("Scenario 1") {

    val actualInput =
      """
        |2
      """.stripMargin

    val expectedOutput =
      """
        |min(int, int)
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }

  test("Scenario 2") {

    val actualInput =
      """
        |4
      """.stripMargin

    val expectedOutput =
      """
        |min(int, min(int, min(int, int)))
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }
}
