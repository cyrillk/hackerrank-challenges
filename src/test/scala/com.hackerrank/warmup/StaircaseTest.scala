package com.hackerrank.warmup

import java.io.ByteArrayInputStream

import com.hackerrank.warmup.Solution._
import org.scalatest.{FunSuite, Matchers}

class StaircaseTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "6"
    )

    val expectedOutput = List(
      "     #",
      "    ##",
      "   ###",
      "  ####",
      " #####",
      "######"
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

private object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val n = sc.nextInt()

    for (i <- 1 to n) {
      println(" " * (n - i) + "#" * i)
    }
  }
}