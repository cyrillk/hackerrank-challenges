package sample.matchers

import java.io.ByteArrayInputStream

import org.scalatest.Matchers

trait SystemIOStringMatcher extends Matchers {

  protected def assertResults(main: => Unit)(actualInput: String, expectedOutput: String): Unit = {
    val is = new ByteArrayInputStream(actualInput.getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main
      }
    }

    println(expectedOutput)

    expectedOutput shouldEqual os.toString.dropRight(1)
  }
}