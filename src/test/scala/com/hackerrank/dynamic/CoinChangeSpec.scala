package com.hackerrank.dynamic

import com.hackerrank.sample.SystemInputOutputMatcher
import org.scalatest.{FlatSpec, Matchers}

/**
  * https://www.hackerrank.com/challenges/coin-change
  *
  * http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
  */
class CoinChangeSpec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  private def toAssert = assertResults(CoinChangeSpec.main(Array.empty[String])) _

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

private object CoinChangeSpec {

  //  private def search(amount: Int, coins: Array[Int], m: Int): Int = {
  //    (amount, coins) match {
  //      case (0, _) => 1
  //      case (n, _) if n < 0 => 0
  //      case (n, c) if n > 0 && m == c.length => 0
  //      case (n, c) => search(n - c(m), c, m) + search(n, c, m + 1)
  //    }
  //  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    val firstLine = sc.nextLine().split(" ")
    val n = firstLine(0).trim.toInt
    val m = firstLine(1).trim.toInt

    val coins = sc.nextLine().split(" ", m).map(_.trim.toInt)

    val solution = Array.ofDim[Int](coins.length + 1, n + 1) // + 1 -> zero values

    (0 to coins.length) foreach (i => solution(i)(0) = 1)

    for (i <- 1 to coins.length) {
      for (j <- 0 to n) {
        if (coins(i - 1) <= j) {
          solution(i)(j) = solution(i - 1)(j) + solution(i)(j - coins(i - 1))
        } else {
          solution(i)(j) = solution(i - 1)(j)
        }
      }
    }

    solution.foreach(s => println(s.mkString(",")))

    println(solution(coins.length)(n))
  }
}