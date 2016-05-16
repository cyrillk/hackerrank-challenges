package com.hackerrank.dynamic

import com.hackerrank.sample.SystemInputOutputMatcher
import org.scalatest.{FlatSpec, Matchers}

/**
  * https://www.hackerrank.com/challenges/coin-change
  */
class CoinChangeNaiveSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(CoinChangeNaiveSpec.main(Array.empty[String])) _

  "Scenario #1" should "pass" in {

    val actualInput = List(
      "4 3",
      "1 2 3"
    )

    val expectedOutput = List(
      "4"
    )

    toAssert(actualInput, expectedOutput)
  }

  "Scenario #2" should "pass" in {

    val actualInput = List(
      "10 4",
      "2 5 3 6"
    )

    val expectedOutput = List(
      "5"
    )

    toAssert(actualInput, expectedOutput)
  }
}

private object CoinChangeNaiveSpec {

  private def search(amount: Int, coins: Array[Int], m: Int): Int = {
    (amount, coins) match {
      case (0, _) => 1
      case (n, _) if n < 0 => 0
      case (n, c) if n > 0 && m == c.length => 0
      case (n, c) => search(n - c(m), c, m) + search(n, c, m + 1)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    val firstLine = sc.nextLine().split(" ")
    val n = firstLine(0).trim.toInt
    val m = firstLine(1).trim.toInt

    val coins = sc.nextLine().split(" ", m).map(_.trim.toInt)

    val result = search(n, coins, 0)

    println(result)
  }
}