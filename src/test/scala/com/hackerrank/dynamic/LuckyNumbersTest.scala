package com.hackerrank.dynamic

import java.io.ByteArrayInputStream

import com.hackerrank.dynamic.LuckyNumbersTest._
import org.scalatest.{FunSuite, Matchers}

import scala.io.StdIn

class LuckyNumbersTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "2",
      "1 20",
      "120 130"
    )

    val expectedOutput = List(
      "4",
      "1"
    )

    assertResults(actualInput, expectedOutput)
  }

  test("Many") {

    val actualInput = List(
      "1",
      s"${Int.MaxValue} ${Int.MaxValue + 100000L}"
    )

    val expectedOutput = List(
      "8906"
    )

    assertResults(actualInput, expectedOutput)
  }

  test("Too Many") {

    val actualInput = List(
      "1",
      s"305402977547472311 387592951340431309"
    )

    val expectedOutput = List(
      "5504086913485671"
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object LuckyNumbersTest {

  private def stream(i: Long = 1): Stream[Long] = i #:: stream(i + 1)

  // "9999999999999999999".map(_ - 48).map(d => d * d).sum = 1539
  private val primes = (1 to 1522).filter(p => isPrime(p)).toSet

  def main(args: Array[String]) {

    val n = StdIn.readLine().toInt

    for (_ <- 0 until n) {

      val line = StdIn.readLine()
      val values = line.split(" ", 2)

      val result = stream(values.head.toLong).takeWhile(_ <= values.last.toLong) filter {
        case p if p < 10 => false
        case p if p > 10 =>
          val digits = p.toString.map(_ - 48) // .filter(_ != 0)
          primes.contains(digits.sum) && primes.contains(digits.map(d => d * d).sum)
        // isPrime(digits.sum) && isPrime(digits.map(d => d * d).sum)
        case _ => false
      }

      println(result.size)
    }
  }

  private def isPrime(p: Long): Boolean = {
    p match {
      case 1 => false
      case 2 => true
      case n if (n & 1) == 0 => false // to catch odd numbers
      case n =>
        val root = Math.ceil(Math.sqrt(n)).toInt
        !(3 to root).exists(p % _ == 0)
    }
  }
}