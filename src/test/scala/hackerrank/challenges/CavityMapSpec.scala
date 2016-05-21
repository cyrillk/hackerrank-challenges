package hackerrank.challenges

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

import scala.collection.mutable

class CavityMapSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(CavityMapSpec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "4",
      "1112",
      "1912",
      "1892",
      "1234"
    )

    val expectedOutput = List(
      "1112",
      "1X12",
      "18X2",
      "1234"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object CavityMapSpec {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val count = sc.nextLine().trim.toInt

    val array = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[String]]

    for (_ <- 0 until count) {
      val line = sc.nextLine().trim.toCharArray.map(b => String.valueOf(b - 48))
      array += mutable.ArrayBuffer(line: _*)
    }

    val cavities = mutable.ListBuffer.empty[(Int, Int)]

    for (i <- 1 until count - 1) {
      for (j <- 1 until count - 1) {
        val item = array(i)(j).toInt

        if (array(i - 1)(j).toInt < item && array(i + 1)(j).toInt < item &&
          array(i)(j - 1).toInt < item && array(i)(j + 1).toInt < item) {
          cavities += ((i, j))
        }
      }
    }

    cavities foreach { case (i, j) =>
      array(i).update(j, "X")
    }

    array.foreach(s => println(s.mkString("")))
  }
}