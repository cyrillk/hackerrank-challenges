package challenges

import matchers.SystemIOStringMatcher
import org.scalatest.{FunSuite, Matchers}

class CandyRobotSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def toAssert = assertResults(CandyRobot.main(Array.empty[String])) _

  test("Scenario 1") {

    val actualInput =
      """
        |8 4
        |3 1 7 5
      """.stripMargin

    val expectedOutput =
      """
        |11
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }

  test("Scenario 2") {

    val actualInput =
      """
        |8 1
        |3
      """.stripMargin

    val expectedOutput =
      """
        |0
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }

  test("Scenario 3") {

    val actualInput =
      """
        |8 5
        |0 0 0 0 3
      """.stripMargin

    val expectedOutput =
      """
        |0
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }

  test("Scenario 4") {

    val actualInput =
      """
        |8 10
        |0 0 0 0 0 0 0 0 5 3
      """.stripMargin

    val expectedOutput =
      """
        |5
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }

  test("Scenario 5") {

    val actualInput =
      """
        |8 3
        |5 2 4
      """.stripMargin

    val expectedOutput =
      """
        |5
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }
}
