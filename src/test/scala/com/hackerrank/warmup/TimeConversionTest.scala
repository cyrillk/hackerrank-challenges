package com.hackerrank.warmup

import java.io.ByteArrayInputStream
import java.text.SimpleDateFormat

import com.hackerrank.warmup.TimeConversionTest._
import org.scalatest.{FunSuite, Matchers}

class TimeConversionTest extends FunSuite with Matchers {

  test("Sample") {

    val actualInput = List(
      "07:05:45PM"
    )

    val expectedOutput = List(
      "19:05:45"
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

private object TimeConversionTest {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val time = sc.next()

    val parsedDate = new SimpleDateFormat("hh:mm:ssa").parse(time)
    val result = new SimpleDateFormat("HH:mm:ss").format(parsedDate)

    println(result)
  }
}