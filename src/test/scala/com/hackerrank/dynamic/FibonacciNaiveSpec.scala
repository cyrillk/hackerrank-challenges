package com.hackerrank.dynamic

import com.hackerrank.sample.SystemInputOutputMatcher
import org.scalatest.{FlatSpec, Matchers}

class FibonacciNaiveSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(FibonacciNaiveSpec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "20"
    )

    val expectedOutput = List(
      "6765"
    )

    toAssert(actualInput, expectedOutput)
  }

  "Scenario #2" should "pass" in {

    val actualInput = List(
      "40"
    )

    val expectedOutput = List(
      "102334155"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object FibonacciNaiveSpec {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val number = sc.nextLine().trim.toInt

    println(search(number))
  }

  private def search(num: Long): Long = {
    num match {
      case 0 => 0
      case 1 => 1
      case _ => search(num - 1) + search(num - 2)
    }
  }
}