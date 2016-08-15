package hackerrank.challenges

import matchers.SystemIOStringMatcher
import org.scalatest.{FunSuite, Matchers}

class EvalExSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def toAssert = assertResults(EvalEx.main(Array.empty[String])) _

  test("Scenario 1") {

    val actualInput =
      """
        |4
        |20.0000
        |5.0000
        |0.5000
        |-0.5000
      """.stripMargin


    val expectedOutput =
      """
        |2423600.2500
        |143.6895
        |1.6487
        |0.6065
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }
}