package com.hackerrank.warmup

import com.hackerrank.warmup.SimpleArraySumTest._
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class SimpleArraySumTest extends FunSuite with Matchers with BeforeAndAfter {

  // println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)

  test("Simple Array Sum") {

    val actualInput = List("6", "1 2 3 4 10 11")
    val expectedOutput = "31"
    val result = go(actualInput)

    assert(expectedOutput == result)
  }
}

object SimpleArraySumTest {

  def main(args: Array[String]) {
    println(go(io.Source.stdin.getLines().toList))
  }

  private def go(input: List[String]): String = {
    input match {
      case n :: array :: Nil => array.split(" ", n.toInt).map(_.toInt).sum.toString
      case _ => throw new UnsupportedOperationException("failure")
    }
  }
}
