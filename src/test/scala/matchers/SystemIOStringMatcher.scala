package matchers

import java.io.ByteArrayInputStream

import org.scalatest.Matchers

trait SystemIOStringMatcher extends Matchers {

  protected def assertResults(main: => Unit)(actualInput: String, expectedOutput: String): Unit = {

    val actualInputTrimmed = actualInput.trim
    val expectedOutputTrimmed = expectedOutput.trim

    val is = new ByteArrayInputStream(actualInputTrimmed.getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        main
      }
    }

    println(expectedOutputTrimmed)

    expectedOutputTrimmed shouldEqual os.toString.dropRight(1)
  }
}