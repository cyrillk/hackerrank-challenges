package challenges

import matchers.SystemIOStringMatcher
import org.scalatest.{FunSuite, Matchers}

class MelodiousPasswordSuite extends FunSuite with Matchers with SystemIOStringMatcher {

  private def result = retrieveResults(MelodiousPassword.main(Array.empty[String])) _

  test("Scenario 1") {

    val actualInput =
      """
        |1
      """.stripMargin

    val output = result(actualInput)

    output.split('\n').length shouldBe 25
  }

  test("Scenario 2") {

    val actualInput =
      """
        |2
      """.stripMargin

    val output = result(actualInput)

    output.split('\n').length shouldBe 200
  }

  test("Scenario 3") {

    val actualInput =
      """
        |6
      """.stripMargin

    val output = result(actualInput)

    output.split('\n').length shouldBe 2500
  }
}
