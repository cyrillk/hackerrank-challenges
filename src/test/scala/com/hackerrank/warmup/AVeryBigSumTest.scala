package com.hackerrank.warmup

import com.hackerrank.warmup.AVeryBigSumTest._
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class AVeryBigSumTest extends FunSuite with Matchers with BeforeAndAfter {

  test("Simple Array Sum") {

    val actualInput = List("5", "1000000001 1000000002 1000000003 1000000004 1000000005")
    val expectedOutput = "5000000015"
    val result = go(actualInput)

    assert(expectedOutput == result)
  }
}

object AVeryBigSumTest {

  def main(args: Array[String]) {
    println(go(io.Source.stdin.getLines().toList))
  }

  private def go(input: List[String]): String = {
    input match {
      case n :: array :: Nil => array.split(" ", n.toInt).map(_.toLong).sum.toString
      case _ => throw new UnsupportedOperationException("failure")
    }
  }
}
