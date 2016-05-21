package hackerrank.dynamic

import java.io.ByteArrayInputStream

import org.scalatest.{FunSuite, Matchers}

class MaximumSubarrayTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "2",
      "4",
      "1 2 3 4",
      "6",
      "2 -1 2 3 4 -5"
    )

    val expectedOutput = List(
      "10 10",
      "10 11"
    )

    assertResults(actualInput, expectedOutput)
  }

  test("Minus") {

    val actualInput = List(
      "2",
      "4",
      "-1 -2 -3 -4",
      "9",
      "-2 1 -3 4 -1 2 1 -5 4"
    )

    val expectedOutput = List(
      "-1 -1",
      "6 12"
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        MaximumSubarrayTest.main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object MaximumSubarrayTest {

  case class Max(maxEndingHere: Int, maxSoFar: Int, maxTotal: Int)

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val n = sc.nextLine().toInt

    for (_ <- 0 until n) {
      val size = sc.nextLine().toInt
      val values = sc.nextLine().split(" ", size).map(_.toInt)

      val max = values.tail.foldLeft(Max(values.head, values.head, values.head)) { (m, x) =>
        val maxEndingHere = Math.max(x, m.maxEndingHere + x)
        val maxSoFar = Math.max(m.maxSoFar, maxEndingHere)
        val maxTotal = m.maxTotal match {
          case t if t < 0 => Math.max(m.maxTotal, x)
          case _ => Math.max(m.maxTotal, m.maxTotal + x)
        }

        Max(maxEndingHere, maxSoFar, maxTotal)
      }

      println(s"${max.maxSoFar} ${max.maxTotal}")
    }
  }
}