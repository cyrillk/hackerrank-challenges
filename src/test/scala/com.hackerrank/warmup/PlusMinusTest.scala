package com.hackerrank.warmup

import java.io.ByteArrayInputStream

import com.hackerrank.warmup.PlusMinusTest._
import org.scalatest.{FunSuite, Matchers}

class PlusMinusTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "6",
      "-4 3 -9 0 4 1"
    )

    val expectedOutput = List(
      "0.500000",
      "0.333333",
      "0.166667"
    )

    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }

  test("Zero") {

    val actualInput = List(
      "6",
      "-4 3 -9 -1 4 1"
    )

    val expectedOutput = List(
      "0.500000",
      "0.500000",
      "0.000000"
    )

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

object PlusMinusTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    var n = sc.nextInt()
    var arr = new Array[Int](n)
    for (arr_i <- 0 to n - 1) {
      arr(arr_i) = sc.nextInt()
    }

    echo(arr.count(_ > 0) / n.toDouble)
    echo(arr.count(_ < 0) / n.toDouble)
    echo(arr.count(_ == 0) / n.toDouble)
  }

  def echo(value: Double): Unit = {
    println(f"$value%2.6f")
  }
}