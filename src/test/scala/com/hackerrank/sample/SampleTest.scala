package com.hackerrank.sample

import java.io.ByteArrayInputStream

import org.scalatest.{FunSuite, Matchers}

class SampleTest extends FunSuite with Matchers {

  test("Sample scenario") {

    val actualInput = List(
      "1"
    )

    val expectedOutput = List(
      "1"
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        SampleTest.main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object SampleTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val n = sc.nextInt()

    println(n)
  }
}