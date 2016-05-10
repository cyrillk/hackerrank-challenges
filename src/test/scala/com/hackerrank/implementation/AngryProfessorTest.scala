package com.hackerrank.implementation

import java.io.ByteArrayInputStream

import org.scalatest.{FunSuite, Matchers}

/**
  * https://www.hackerrank.com/challenges/angry-professor
  */
class AngryProfessorTest extends FunSuite with Matchers {

  test("Sample scenario") {

    val actualInput = List(
      "2",
      "4 3",
      "-1 -3 4 2",
      "4 2",
      "0 -1 2 1"
    )

    val expectedOutput = List(
      "YES",
      "NO"
    )

    assertResults(actualInput, expectedOutput)
  }

  test("Zero scenario") {

    val actualInput = List(
      "3",
      "4 3",
      "-1 0 0 0",
      "4 3",
      "1 0 0 0",
      "4 3",
      "0 0 0 0"
    )

    val expectedOutput = List(
      "NO",
      "NO",
      "NO"
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        AngryProfessorTest.main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object AngryProfessorTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val n = sc.nextLine().toInt

    (0 until n) foreach { _ =>
      // reads input
      val line1 = sc.nextLine().split(" ", 2)
      val students = line1(0).toInt
      val threshold = line1(1).toInt

      val line2 = sc.nextLine()
      val times = line2.split(" ", students)

      // produces result
      times count(_.toInt <= 0) match {
        case s if s < threshold => println("YES")
        case _ => println("NO")
      }
    }
  }
}