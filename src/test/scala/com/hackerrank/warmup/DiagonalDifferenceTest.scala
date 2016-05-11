package com.hackerrank.warmup

import java.io.ByteArrayInputStream

import com.hackerrank.warmup.DiagonalDifferenceTest._
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class DiagonalDifferenceTest extends FunSuite with Matchers with BeforeAndAfter {

  test("Diagonal Difference") {

    val actualInput = List("3",
      "11 2 4",
      "4 5 6",
      "10 8 -12")

    val expectedOutput = "15"

    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main(Array.empty[String])
      }
    }

    expectedOutput shouldEqual os.toString.dropRight(1)
  }
}

object DiagonalDifferenceTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (Console.in)
    val n = sc.nextInt()
    val a = Array.ofDim[Int](n, n)
    for (a_i <- 0 until n) {
      for (a_j <- 0 until n) {
        a(a_i)(a_j) = sc.nextInt()
      }
    }

    println(Math.abs(leftRight(a, n) - rightLeft(a, n)))
  }

  private def leftRight(a: Array[Array[Int]], n: Int): Int = {

    val numbers = scala.collection.mutable.ListBuffer.empty[Int]

    for (i <- 0 until n) {
      numbers.append(a(i)(i))
    }

    numbers.toList.sum
  }

  private def rightLeft(a: Array[Array[Int]], n: Int): Int = {

    val numbers = scala.collection.mutable.ListBuffer.empty[Int]

    for (i <- 0 until n) {
      numbers.append(a(i)(n - i - 1))
    }

    numbers.toList.sum
  }
}