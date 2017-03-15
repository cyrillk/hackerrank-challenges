package matchers

import java.io.ByteArrayInputStream

import org.scalatest.Matchers

trait SystemIOStringMatcher extends Matchers {

  protected def retrieveResults(main: => Unit)(actualInput: String): String = {

    val actualInputTrimmed = actualInput.trim

    val is = new ByteArrayInputStream(actualInputTrimmed.getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main
      }
    }

    os.toString.dropRight(1)
  }

  protected def assertResults(main: => Unit)(actualInput: String, expectedOutput: String): Unit = {

    val expectedOutputTrimmed = expectedOutput.trim

    println(expectedOutputTrimmed)

    expectedOutputTrimmed shouldEqual retrieveResults(main)(actualInput)
  }
}