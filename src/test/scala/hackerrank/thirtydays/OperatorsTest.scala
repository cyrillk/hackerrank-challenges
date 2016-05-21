package hackerrank.thirtydays

import java.io.ByteArrayInputStream

import org.scalatest.{FunSuite, Matchers}

class OperatorsTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "12.00",
      "20",
      "8"
    )

    val expectedOutput = List(
      "The total meal cost is 15 dollars."
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        OperatorsTest.main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object OperatorsTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val price = sc.nextLine().toDouble
    val tip = sc.nextLine().toInt
    val tax = sc.nextLine().toInt

    val total = Math.round(price + price * tip / 100 + price * tax / 100)

    println(s"The total meal cost is $total dollars.")
  }
}