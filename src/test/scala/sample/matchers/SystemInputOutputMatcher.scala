package sample.matchers

import java.io.ByteArrayInputStream

import org.scalatest.Matchers

trait SystemInputOutputMatcher extends Matchers {

  protected def assertResults(main: => Unit)(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main
      }
    }

    println(expectedOutput.mkString("\n"))

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}