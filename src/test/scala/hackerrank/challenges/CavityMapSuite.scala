package hackerrank.challenges

import org.scalatest.{FunSuite, Matchers}
import matchers.SystemIOStringMatcher

class CavityMapSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def toAssert = assertResults(CavityMap.main(Array.empty[String])) _

  test("Scenario 1") {

    val actualInput =
      """
        |4
        |1112
        |1912
        |1892
        |1234
      """.stripMargin

    val expectedOutput =
      """
        |1112
        |1X12
        |18X2
        |1234
      """.stripMargin

    toAssert(actualInput, expectedOutput)
  }
}
